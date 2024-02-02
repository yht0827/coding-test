def solution(absolutes, signs):
    sum =0 
    for i,j in zip(absolutes, signs):
        if j =='true':
            sum += i
        else:
            sum -= i
    return sum

def mySolution(absolutes, signs):
    return sum( absolute if sign else -absolute for absolute, sign in zip(absolutes, signs))
print(mySolution([4,7,12], ['true','false','true'])) # 9
print(mySolution([1,2,3],['false','false','true'])) # 0