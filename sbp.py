import pandas as pd

ID_COLUMN = 0
TIME_COLUMN = 1
SBP_COLUMN = 2


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
            if curr_id not in result:
                keep_accumulating = False
            if not keep_accumulating:
                curr_item["num_episodes"] += 1
                prev_time = brics.iloc[row, TIME_COLUMN]
            curr_item["cumulative_minutes"] += int (((brics.iloc[row, TIME_COLUMN] - prev_time).total_seconds()) / 60)
            result[curr_id] = curr_item
            keep_accumulating = True
        elif brics.iloc[row, SBP_COLUMN] >= 70 and keep_accumulating:
            keep_accumulating = False
            curr_item = result.get(curr_id, {"num_episodes": 1, "cumulative_minutes": 0})
            curr_item["cumulative_minutes"] += int (((brics.iloc[row, TIME_COLUMN] - prev_time).total_seconds()) / 60)
            result[curr_id] = curr_item
        prev_time = brics.iloc[row, TIME_COLUMN]
    return result


if __name__ == "__main__":
    # Read the file into a DataFrame
    sbp_data = pd.read_csv("SBP-home.csv")
    # convert string into timestamp
    sbp_data["time"] = pd.to_datetime(sbp_data["time"], format="%H:%M")
    data = sum_episodes(sbp_data)
    data_frame = pd.DataFrame(data)
    print(data_frame)


