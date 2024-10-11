#include <stdio.h>

int main() {
    int a, b;

    // 두 정수를 입력받는다
    printf("두 정수를 입력하세요: ");
    scanf("%d %d", &a, &b);

    // 비교 연산자를 사용하여 결과를 출력한다
    printf("%d\n", a > b);

    return 0;
}
