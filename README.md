# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 오구사항
* 구입 금액을 입력하면 금액에 해당하는 로또를 발급한다.
* 당첨번호를 입력하여 당첨통계를 구한다.

## 책임주도개발
1. 사용자에게 제공해야하는 기능인 시스템 책임을 파악한다.
    * 금액에 해당하는 로또를 랜덤으로 발급한다.
    * 발급한 로또 번호와 당첨번호를 비교하여 당첨 통계를 구한다.
 
2. 더 작은 책임으로 분할한다.
    * 로또 랜덤으로 발급
        * 금액 -> 숫자로 변환
        * 숫자만큼 티켓 발행
            * 6개의 숫자를 섞어서 하나의 티켓 발행

    * 발급한 로또와 당첨번호 비교
        * 티켓별로 숫자를 비교한다.
        * 일치 개수를 구한다.
        * 수익률을 계산한다.
    
3. 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.

4. 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.

5. 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.

---
# 문자열 덧셈 계산기
## 기능 요구사항
* 구분자로(,:)로 나눠진 숫자들의 합을 반환
* 커스텀 구분자 지정 가능 //와 \n 사이에 입력 ( ex> "//;\n1:2:3")
* 숫자 또는 음수를 전달한 경우 예외 발생

## 책임주도개발
1. 사용자에게 제공해야하는 기능인 시스템 책임을 파악한다.
    * 입력받은 문자열 숫자들의 합을 반환한다.
    
2. 더 작은 책임으로 분할한다.
    * 구분자로 문자열 계산식을 분리한다.
        * 올바른 숫자인지 확인한다.
        * 커스텀 구분자를 인식한다.
        
    * 분리한 문자열 숫자들을 더한다.
    
3. 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.


4. 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.

5. 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.