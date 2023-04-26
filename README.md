# 로또

## 문자열 계산기

### 기능 요구사항

- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기 구현
- [x] 입력 문자열의 숫자와 사칙 연산 사이에는 **반드시 빈 공백 문자열**이 있다고 가정
  - [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
  - [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] **나눗셈의 경우 결과 값을 정수**로 떨어지는 값으로 한정
- [x] 문자열 계산기는 **사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정**.
  - 예를 들어, `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 10을 출력해야 한다.

## 로또

### 기능 요구사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 입출력 예시

```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

### 프로그래밍 요구사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어, while문 안에 if 문이 있으면 들여쓰기 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능 목록

#### 핵심 기능

- [x] 로또의 번호는 1 이상 45 이하
- [x] 로또 티켓은 6개의 로또 번호를 가진다.
- [x] 당첨 로또티켓과 비교하여 맞춘 개수에 따른 로또 순위들을 반환한다.
- [x] 로또 순위들을 통해 수익률, 순위 당 몇 개씩 맞췄는지를 출력한다.

#### LottoNumber

- [x] 1이상 45이하의 숫자
- [x] 그 외의 숫자가 입력되는 경우에는 IllegalArgumentException throw

#### LottoTicket

- [x] 로또 티켓은 6개까지만 입력 가능
- [x] 해당 로또번호가 있는지 확인
- [x] 다른 로또티켓과 비교하여 맞춘 개수 반환

#### LottoTickets

- [x] 로또티켓 추가
- [x] 전체 로또티켓들에 대해 당첨번호와 비교하여 각 맞춘 개수를 담은 리스트 반환

#### RandomLottoStrategy

- [x] 1 ~ 45의 랜덤번호 6개를 가진 로또티켓 반환

#### LottoRank

- [x] 로또순위 리스트 반환
- [x] 맞춘개수와 보너스에 따라 맞는 로또순위 반환
- [x] 로또순위에 따라 해당 상금 반환

#### LottoGame

- [x] 각 로또티켓들에 대한 로또순위 리스트를 가지고 로또결과로 반환 

#### LottoResult

- [x] 수익률 반환
- [x] 로또순위와 각 로또순위의 개수 반환

#### LottoVendingMachine

- [x] 사용자의 티켓구매 횟수를 입력받아 1 ~ 45 랜덤번호를 가진 로또티켓 리스트 반환
- [x] 사용자가 구매한 티켓들과 지난 주 당첨 번호를 입력받아 게임 생성
- [x] 게임을 플레이하여 결과 반환
