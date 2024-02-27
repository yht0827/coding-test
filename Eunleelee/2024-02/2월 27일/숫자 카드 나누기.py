from math import gcd
from functools import reduce


def solution(a, b):
    a, b = list(set(a)), list(set(b))

    findGCD = lambda array: reduce(lambda acc, cur: gcd(acc, cur), array, 0)
    checkGCD = lambda array, GCD: GCD if all(e % GCD != 0 for e in array) else 0

    gcdA, gcdB = checkGCD(b, findGCD(a)), checkGCD(a, findGCD(b))

    return 0 if not (gcdA or gcdB) else max(gcdA, gcdB)
