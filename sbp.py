import pandas as pd

ID_COLUMN = 0
TIME_COLUMN = 1
SBP_COLUMN = 2
SBP_FILE_PATH = "SBP-home.csv"
TIME_COLUMN_NAME = "time"
TIME_FORMAT = "%H:%M"


def process(df):
    if len(df) == 0:
        return {}
    prev_time = df.iloc[0, TIME_COLUMN]
    keep_accumulating = False
    result = {}

    for row in range(len(df)):
        curr_id = df.iloc[row, ID_COLUMN]
        if df.iloc[row, SBP_COLUMN] < 70:
            curr_item = result.get(curr_id, {"num_episodes": 0, "cumulative_minutes": 0})
            # Start the first episode for the current ID
            if curr_id not in result:
                keep_accumulating = False
            # Reset the previous time for a new episode
            if not keep_accumulating:
                curr_item["num_episodes"] += 1
                prev_time = df.iloc[row, TIME_COLUMN]
            curr_item["cumulative_minutes"] += timedelta_to_minute(df.iloc[row, TIME_COLUMN], prev_time)
            result[curr_id] = curr_item
            keep_accumulating = True
        # Finish the current episode when SBP >= 70 while the previous SBP < 70
        elif keep_accumulating:
            result.get(curr_id)["cumulative_minutes"] += timedelta_to_minute(df.iloc[row, TIME_COLUMN], prev_time)
            keep_accumulating = False
        prev_time = df.iloc[row, TIME_COLUMN]
    return result


def timedelta_to_minute(time1, time2):
    """Take in two datetime object, convert the timedelta to minute in int format"""
    return int (((time1 - time2).total_seconds()) / 60)


def find_lowest_sbp(df):
    sbp_durations = {}
    curr_min_sbp = {}
    prev_timestamp = 0
    for row in range(len(df)):
        curr_id = df.iloc[row, ID_COLUMN]
        curr_sbp = df.iloc[row, SBP_COLUMN]
        curr_timestamp = df.iloc[row, TIME_COLUMN]
        if curr_id not in sbp_durations:
            sbp_durations[curr_id] = []
            curr_min_sbp[curr_id] = (float("inf"), 0)
            prev_timestamp = df.iloc[row, TIME_COLUMN]
        sbp_durations[curr_id].append((curr_sbp, 0))
        new_sbp_duration = []
        for sbp, duration in sbp_durations[curr_id][:-1]:
            if sbp >= curr_sbp:
                duration += timedelta_to_minute(curr_timestamp, prev_timestamp)
                new_sbp_duration.append((sbp, duration))
            if duration >= 10:
                curr_min_sbp[curr_id] = compare_sbp_duration(curr_min_sbp[curr_id], (sbp, duration))
        new_sbp_duration.append(sbp_durations[curr_id][-1])
        sbp_durations[curr_id] = new_sbp_duration
        prev_timestamp = curr_timestamp
    return curr_min_sbp


def compare_sbp_duration(this, that):
    """Return the tuple that has a smaller first item, if the first items are equal, return the tuple that has a greater second item"""
    if this[0] < that[0]:
        return this
    elif this[0] > that[0]:
        return that
    return this if this[1] > that[1] else that


if __name__ == "__main__":
    # Read the file into a DataFrame
    sbp_data = pd.read_csv(SBP_FILE_PATH)
    # convert the time column into timestamp
    sbp_data[TIME_COLUMN_NAME] = pd.to_datetime(sbp_data[TIME_COLUMN_NAME], format=TIME_FORMAT)

    # question 1
    data = process(sbp_data)
    print(pd.DataFrame(data))

    # question 3
    lowest_sbps = find_lowest_sbp(sbp_data)
    print(lowest_sbps)

"""
Result for the first question:
                    1   12  13  15  16  17  29  32  37  38  45  59  61  66  68
num_episodes         2   1   2   1   1   3   1   5   1   1   2   1   5   1   1
cumulative_minutes   3   4   9   3   1   6   5  12   1   3  10   6  13   5   2

Result for the third question:
{1: (92, 11), 2: (106, 10), 3: (105, 12), 4: (99, 11), 5: (107, 10), 6: (117, 10), 7: (100, 10), 8: (93, 13), 
9: (116, 10), 10: (85, 15), 11: (109, 10), 12: (95, 19), 13: (83, 10), 14: (94, 12), 15: (87, 21), 16: (95, 15), 
17: (98, 20), 18: (96, 10), 19: (102, 15), 20: (100, 15), 21: (92, 10), 22: (96, 10), 23: (115, 12), 24: (96, 11), 
25: (93, 10), 26: (91, 10), 27: (86, 13), 28: (101, 13), 29: (92, 10), 30: (122, 14), 31: (102, 14), 32: (86, 12), 
33: (100, 24), 34: (102, 15), 35: (123, 10), 36: (130, 25), 37: (85, 17), 38: (86, 16), 39: (109, 16), 40: (95, 15), 
41: (166, 22), 42: (86, 11), 43: (98, 10), 44: (115, 11), 45: (92, 15), 46: (97, 15), 47: (108, 10), 48: (91, 10), 
49: (95, 10), 50: (95, 14), 51: (113, 20), 52: (121, 15), 53: (119, 24), 54: (111, 16), 55: (104, 15), 56: (110, 30), 
57: (100, 10), 58: (94, 20), 59: (101, 12), 60: (124, 20), 61: (92, 14), 62: (112, 10), 63: (103, 15), 64: (86, 12), 
65: (102, 15), 66: (77, 10), 67: (130, 12), 68: (87, 11), 69: (103, 10)}
"""
