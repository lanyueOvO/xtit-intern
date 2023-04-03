#include "lcd.h"

int main()
{
    // 1.lcd显示的初始化
    int fd_lcd = lcd_init();

    draw_circle(100, 100, 100, 0);
    sleep(1);
    draw_rectangle(50, 50, 50, 50, 0);

    // 结束 进行相应收尾工作
    lcd_end(fd_lcd);

	return 0;
}





