import pandas as pd

ID_COLUMN = 0
TIME_COLUMN = 1
SBP_COLUMN = 2
SBP_FILE_PATH = "SBP-home.csv"


def sum_episodes(brics):
    if len(brics)==0:
        return {}
    prev_time = brics.iloc[0, TIME_COLUMN]
    keep_accumulating = False
    result = {}

    for row in range(len(brics)):
        curr_id = brics.iloc[row, ID_COLUMN]
        if brics.iloc[row, SBP_COLUMN] < 70:
            curr_item = result.get(curr_id, {"num_episodes": 0, "cumulative_minutes": 0})
            # encounter the first SBP value < 70 for this ID
            if curr_id not in result:
                keep_accumulating = False
            # Should increment number of episodes since this row is not accumulating but starting a new episode
            # Should reset the previous time since it is a new episode
            if not keep_accumulating:
                curr_item["num_episodes"] += 1
                prev_time = brics.iloc[row, TIME_COLUMN]
            curr_item["cumulative_minutes"] += int (((brics.iloc[row, TIME_COLUMN] - prev_time).total_seconds()) / 60)
            result[curr_id] = curr_item
            keep_accumulating = True
        # Do not handle the case when keep_accumulating = False, no episode in this case
        elif brics.iloc[row, SBP_COLUMN] >= 70 and keep_accumulating:
            # Set the flag to False to end this episode
            keep_accumulating = False
            curr_item = result.get(curr_id, {"num_episodes": 1, "cumulative_minutes": 0})
            curr_item["cumulative_minutes"] += int (((brics.iloc[row, TIME_COLUMN] - prev_time).total_seconds()) / 60)
            result[curr_id] = curr_item
        prev_time = brics.iloc[row, TIME_COLUMN]
    return result


if __name__ == "__main__":
    # Read the file into a DataFrame
    sbp_data = pd.read_csv(SBP_FILE_PATH)
    # convert the time column into timestamp
    sbp_data["time"] = pd.to_datetime(sbp_data["time"], format="%H:%M")
    data = sum_episodes(sbp_data)
    data_frame = pd.DataFrame(data)
    print(data_frame)

"""
Result:
                    1   12  13  15  16  17  29  32  37  38  45  59  61  66  68
num_episodes         2   1   2   1   1   3   1   5   1   1   2   1   5   1   1
cumulative_minutes   3   4   9   3   1   6   5  12   1   3  10   6  13   5   2
"""
