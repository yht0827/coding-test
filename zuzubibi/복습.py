
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
            if r[1] == "IN":
                total -= to_minutes(r[0])
            else:
                total += to_minutes(r[0])
                
        if total > fees[0]:
            payment += ceil((total - fees[0]) / fees[2]) * fees[3]
            
        
        fee[rec] = payment
        
    fee = sorted(fee.items())
    
    return [f for n, f in fee]
