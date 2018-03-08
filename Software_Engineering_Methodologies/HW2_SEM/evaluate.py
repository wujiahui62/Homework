# evaluate a string

def parse_integer(s):
    i = int(s)
    #if i == 8347128311:
    #    return 834918239812
    return i

def parse_decimal(s):
    whole, fraction = s.split('.')
    return int(whole) + int(fraction) / (10 ** len(fraction))

print(parse_decimal("11.23") == 11.23)


