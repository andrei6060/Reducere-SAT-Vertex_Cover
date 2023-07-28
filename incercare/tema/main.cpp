#include <iostream>
#include <fstream>
#include "task.h"
using namespace std;

int main()
{
    Task task;

    int n , m, k , i, j;
    int a[100][200];
    int x[100];
    int l;
    int data[100][100];
    int max = 0;
    ifstream f;
    f.open("./tasks/trial/tests/00-trial/00-trial.in");
    ofstream out;
    out.open("sat.cnf");
    f>>n>>m>>k;
    int value = n + k + k * m*(m-1)/2 + m*k*(k-1)/2;
    out<<"p cnf "<<m*k<<" "<< value;
    out<<endl;
    for(int i = 0; i < m; i++){
        f>>x[i];
        if(x[i]>max)
            max = x[i];
        for(int j = 0; j < x[i]; j++){
            f>>data[i][j];
        }
    }


    int h = 0;
    for(i = 1; i <= m*k; i++){
            if(i % m != 0){
            a[h][i%m-1] = i;
            out<<a[h][i%m-1]<<" ";
            }else{
                a[h][m-1] = i;
                out<<a[h][m-1]<<" ";
            }
    if(i % m == 0){
        a[h][m] = 0;
        out<<a[h][m]<<endl;
    h++;
    }
    }


    for(int g=0; g<k; g++)
    for(i=0; i<m-1; i++){
        for(j=i+1; j<m; j++){
            cout<<"-"<<a[g][i]<<" -"<<a[g][j]<<" "<< 0;
            cout<<endl;
        }

    }
    for (int i = 0; i < m; i++) {
    for (int j = 0; j < k; j++) {
      for (int x = j + 1; x < k; x++) {
        cout << -a[j][i] <<" "<< -a[x][i] <<" "<< 0 << endl;
      }
    }
  }

    for(int contor = 1; contor <=n; contor ++){
        for(i = 0; i< m; i++)
        for(j = 0; j< max; j++)
            if(data[i][j] == contor){
                int aux = i+1;
                while(aux<=m*k){
                    out<<aux<<" ";
                    aux+=m;
                }
            }
    out<<"0"<<endl;
    }
    task.ask_oracle();
    ifstream output_oracle;
    output_oracle.open("sat.sol");
    char s[10];
    int no, q, arr[10000];
    output_oracle>>s;
    cout<<s<<endl;
    if(strcmp(s,"True")==0){
    int cont = 0;
    output_oracle>>no;
    for(int i = 0; i < no; i++){
        output_oracle>>q;
        if(q>0){
                if(q==m){
                arr[cont] = q;
                }else{
            arr[cont] = q%m;}
            cont++;
        }
    }
    cout<<cont<<endl;
    for(int i =0; i<cont; i++)
        cout<<arr[i]<<" ";
    }
    return 0;
}
