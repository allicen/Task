import re

pattern = r'^[1-7]T[ABE]X[ ][0-9]{4}$'


def checkNumber(numbers):
    number = int(numbers)
    if number != 0:
        return True


i = int(input())
check = 0
while i > 0:
    string = input()
    if len(string) == 9:
        if re.match(pattern, string) is not None:
            if string[0] == '7' and (string[2] == 'A' or string[2] == 'B' or string[2] == 'E'):
                numbers = string[5 : : 1]
                if checkNumber(numbers):
                    check += 1
            elif string != '7' and (string[2] == 'A' or string[2] == 'B'):
                numbers = string[5:: 1]
                if checkNumber(numbers):
                    check += 1

    i -= 1

print(check)