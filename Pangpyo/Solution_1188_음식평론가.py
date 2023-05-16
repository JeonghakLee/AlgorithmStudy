import math

N, M = map(int, input().split())
N %= M
gcd = math.gcd(N, M)
print((M // gcd - 1) * gcd)
