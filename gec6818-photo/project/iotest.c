#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(){
    int in,out,red;

    char bytebuff[64]; 

    in = open("./you.txt", O_RDWR);

    out = open("./xx.txt", O_WRONLY|O_CREAT);  

    while ( (red = read(in, bytebuff,64)) == -1)
    {
        write(out, bytebuff, 64);
    }

}