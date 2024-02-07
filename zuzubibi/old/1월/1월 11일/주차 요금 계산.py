# def solution(fees, records):
#     base_time, base_m, part_time, part_m = fees
#     for i in records:
#         time, num, ty = i.split(" ")
#         h,m = map(int, time.split(":"))
#         total_time = h*60+m
#     return

# --------------------------------------------------------
from math import ceil
def to_minutes(time):
    h, m = map(int, time.split(':'))
    return h*60 + m

def otherSolution(fees, records):
    recs = {}
    fee = {}

    for record in records:
        time, num, io = record.split()

        if num in recs:
            recs[num].append([time, io])
        else:
            recs[num] = [[time, io]]

    for rec in recs:
        total = 0
        payment = fees[1]

        if len(recs[rec]) % 2 != 0:
            recs[rec].append(["23:59", "OUT"])
        
        for r in recs[rec]:
            if r[1] =='IN':
                total -= to_minutes(r[0])
            else:
                total += to_minutes(r[0])
        if total > fees[0]:
            payment += ceil((total - fees[0]) / fees[2]) * fees[3]
        
        fee[rec] = payment
    
    fee = sorted(fee.items())

    return [f for n,f in fee]
#----------------------------------------------------------------------
from collections import defaultdict
from math import ceil

class Parking:
    def __init__(self, fees):
        self.fees = fees
        self.in_flag = False
        self.in_time = 0
        self.total = 0
    
    def update(self, t, inout):
        self.in_flag = True if inout=='IN' else False
        if self.in_flag:
            self.in_time = str2int(t)
        else:
            self.total += (str2int(t)-self.in_time)

    def clac_fee(self):
        if self.in_flag:
            self.update("23:59", "out")
        add_t = self.total - self.fees[0]
        return self.fees[1] + ceil(add_t/self.fees[2]) * self.fees[3] if add_t >= 0 else self.fees[1]

def str2int(string):
    return int(string[:2])*60 + int(string[3:])

def solution(fees, records):
    recordsDict = defaultdict(lambda: Parking(fees))
    for rcd in records:
        t,car,inout = rcd.split()
        recordsDict[car].update(t, inout)
    return [v.clac_fee() for k,v in sorted(recordsDict.items())]

# [14600, 34400, 5000]
print(solution([180, 5000, 10, 600],["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))

# [0, 591]
print(solution([120, 0, 60, 591], ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]))

# [14841]
print(solution([1, 461, 1, 10], ["00:00 1234 IN"]))