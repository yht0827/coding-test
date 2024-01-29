def solution(files):
    answer = []
    for index, file in enumerate(files):
        head, number, tail = "","",""
        number_check = False
        dectact_str = False

        for i in range(len(file)):
            if dectact_str==False and len(number) < 5 and file[i].isdigit():
                number += file[i]
                number_check=True
                
            elif number_check==False:
                head += file[i]
                
            else:
                tail += file[i]
                dectact_str = True
                
            # print(number, len(number))
        # print(file, head, number, tail)
        
        answer.append((file, head, number, tail, index))
        answer.sort(key=lambda x: (x[1].lower(), int(x[2]), x[4]))
    
    return [''.join(t[0]) for t in answer]

# ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
print(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]))

# ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
print(solution( ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]))