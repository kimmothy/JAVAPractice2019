계산기 클래스

**수정사항**
2019.05.07
CalButton -> OperButton 이름 변경
OperButton, NumButton 클래스 내에서 리스너 정의하고 생성시 리스너 등록되도록 변경
OperButton, NumButton CalculatorLauncer의 inner class로 이동
(클래스 내에서 리스너 생성시 자유롭게 Calculator의 변수에 접근하기 위함)
OperButton 내부에 있었던 열거형 OperType을 CalcluatorLauncher로 이동
(inner class에선 static 선언이 불가함, 열거형은 기본적으로 static)

***Calculator***
이 계산기에서 계산은 세가지 변수 **currentNum**, **previousNum**, **memory**를 통해 이루어집니다.
이 세가지 변수는 모두 double타입의 변수입니다.

**currentNum**은 사용자가 현재 입력하고 있는 수에 해당합니다. 사용자가, 1~0까지의 숫자 버튼을 누를 때마다 갱신됩니다.
'.' 버튼을 눌러 소수점 이하 수를 입력할 수 있습니다. 이 경우 이 변수가 String이 아닌 double 타입으로 정의되었기 때문에
afterDot이라는 또다른 변수를 사용해 자연수 범위와 다른 수식을 사용해 갱신됩니다.

**previousNum**은 계산된 수입니다. '=' 버튼을 누를 때를 비롯하여 calculate()함수가 불릴 때 혹은 메모리를 로드할 때 갱신됩니다.
calculate() 함수는 '=', 'sqrt', 'MS', 'M+', 'M-' 버튼을 누를 떄와, 연속적으로 Operator를 입력할 때 호출됩니다.
'='은 단순히 계산만을 하며 'sqrt'는 계산된 값의 제곱근을 구합니다.
연속적으로 Operator를 입력하는 것은 예를 들자면 2(prev) + 3(current)가 입력된 상황에서, '-'를 누르면 5(prev) - 0(current) 상태가
된다는 것입니다. 즉 현재의 식을 계산하여 **previousNum**에 저장하고, Operator를 새로 입력한 것으로 바꾸어 준다는 것입니다.

**memoryNum**은 사용자가 계산에 사용하기 위해 따로 저장할 수 있는 값입니다.
'MS', 'M+', 'M-', 'MC', 'MR'. 이 다섯 개의 버튼이 **memoryNum**의 관련 버튼입니다.
'MS', 'M+', 'M-' 이 세 버튼은 현재의 식을 계산하여 그 값을 **memoryNum**에 저장하거나 더하거나 뺍니다.
이 경우에 계산의 결과는 이미 메모리에 반영되었으므로 **previousNum**은 0으로 갱신됩니다.
'MC'는 **memoryNum**를 0으로 만들어줍니다. 'MR'은 메모리를 로드합니다. 즉 **memoryNum**의 값을 **previousNum**에 갱신합니다.