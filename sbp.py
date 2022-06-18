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
        # Do not handle the case when keep_accumulating = False, no episode in this case
        elif df.iloc[row, SBP_COLUMN] >= 70 and keep_accumulating:
            result.get(curr_id)["cumulative_minutes"] += timedelta_to_minute(df.iloc[row, TIME_COLUMN], prev_time)
            # Finish the current episode
            keep_accumulating = False
        prev_time = df.iloc[row, TIME_COLUMN]
    return result


def timedelta_to_minute(time1, time2):
    """Take in two datetime object, convert the timedelta to minute in int format"""
    return int (((time1 - time2).total_seconds()) / 60)


if __name__ == "__main__":
    # Read the file into a DataFrame
    sbp_data = pd.read_csv(SBP_FILE_PATH)
    # convert the time column into timestamp
    sbp_data[TIME_COLUMN_NAME] = pd.to_datetime(sbp_data[TIME_COLUMN_NAME], format=TIME_FORMAT)
    data = process(sbp_data)
    print(pd.DataFrame(data))


"""
Result:
                    1   12  13  15  16  17  29  32  37  38  45  59  61  66  68
num_episodes         2   1   2   1   1   3   1   5   1   1   2   1   5   1   1
cumulative_minutes   3   4   9   3   1   6   5  12   1   3  10   6  13   5   2
"""
