# 로또

## 구현 기능 목록

### 구매할 로또 개수
 * [x] 구매할 로또 개수를 입력받는다.
 * [x] 로또 개수는 정수이다. 
 * [x] 로또 개수가 정수가 아니면 예외를 던진다.
 * [x] 로또 개수는 양수이다.
 * [x] 로또 개수가 음수인 경우 예외를 던진다.
 * [x] 로또는 10만원 까지 구매 가능하다. 즉 100장 까지 구매 가능하다.
 * [x] 100장이 넘어가면 예외를 던진다.

### 구입 금액 입력
 * [x] 구매할 로또 개수를 기반으로 가격을 계산한다.
 * [x] 금액은 정수이다.
 * [x] 금액은 정수가 아니면 예외를 던진다.
 * [x] 금액은 양수이다.
 * [x] 금액은 음수인 경우 예외를 던진다.
 * [x] 구입 금액보다 많은 돈을 지불할 경우 차액은 돌려주지 않는다.
 * [x] 로또 가격보다 적은 경우 예외를 던진다.

### 로또 번호
 * [x] 금액을 입력한 즉시 자동으로 로또 번호가 생성된다.
 * [x] 로또 번호는 1 ~ 45 사이의 6자리이다.
 * [x] 로또 번호는 랜덤하게 부여된다.

### 당첨 번호
 * [x] 당첨 번호는 따로 관리된다.
 * [x] 당첨 번호 생성이 완료되면 출력을 진행한다.

### 등수 계산
 * [x] 당첨 번호를 기반으로 등수를 계산한다.
 * [x] 6개의 숫자가 전부 맞으면 1등 상금으로 500만원을 받는다.
 * [x] 5개의 숫자만 맞으면 2등 상금으로 50만원을 받는다.
 * [x] 4개의 숫자만 맞으면 3등 상금으로 5만원을 받는다.
 * [x] 3개의 숫자만 맞으면 4등 상금으로 5000원을 받는다.
 * [x] 2개 이하의 숫자 만큼 맞는 경우 상금을 수령할 수 없다.
 
### 로또 결과
 * [x] 구매 금액을 기반으로 수익률을 계산한다.
 * [x] 가장 높은 당첨 등수를 반환한다.
 * [x] 총 당첨 금액을 계산한다.

### 수익률 출력
 * [x] 구매한 로또 개수와 로또 금액을 출력한다.
 * [x] 당첨 번호를 기반으로 최대 당첨 등수를 출력한다.
 * [x] 수익률을 계산하여 출력한다.

### 유의사항
 * [x] 예외가 발생하면 에러 메시지를 출력하고 다시 입력을 진행한다.