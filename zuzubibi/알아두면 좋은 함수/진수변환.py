"""
숫자 n을 q진수로 변환하는 함수 
"""

def change(n,q):
    rev_base = ''
    
    while n > 0:
        n,mod = divmod(n,q) # n을 q로 나눈 몫과 나머지
        rev_base += str(mod)
    return rev_base[::-1]
