def solution(citations):
    answer = []
    citations.sort() 
    n = len(citations)
    
    for i in range(citations[-1]+1):
        for j, citation in enumerate(citations):
            if i <= citation:
                h_higher_citation = n - j
                break
        if h_higher_citation >= i:
            answer.append(i)
        
    return answer[-1]