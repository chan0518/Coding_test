import Foundation

func solution(_ arr:[Int]) -> [Int] {
    var answer : [Int] = []
    for i in arr{
        var num:Int = i
        if i >= 50 && i%2 == 0 {num=i/2}
        else if i < 50 && i%2 == 1 {num=i*2}
        answer.append(num)
    }
    
    return answer
}