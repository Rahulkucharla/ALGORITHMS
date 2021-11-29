import java.util.*;
public class Knapsack
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=0,capacity=0;
        float max_profit=0.000f;
        System.out.println("Enter number of items:");
        n=sc.nextInt();
        System.out.println("Enter capacity of the Knapsack:");
        capacity=sc.nextInt();
        int profit[]=new int[n];
        int weight[]=new int[n];
        float ratio[]=new float[n];
        
        System.out.println("Enter Weight and profits of each item:");
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter weight and profit for item"+(i+1)+":");
            weight[i]=sc.nextInt();
            profit[i]=sc.nextInt();
            ratio[i]=(float)profit[i]/weight[i];
        }
        sort(ratio,0,n-1,profit,weight);
        for(int i=n-1;i>=0;i--)
        {
            if(capacity>=0)
            {
            if(capacity>=weight[i])
            {
                max_profit=max_profit+(profit[i]*1);
                capacity=capacity-weight[i];
            }
            else if(capacity<weight[i])
            {
                max_profit=max_profit+(profit[i]*(capacity/(float)weight[i]));
                capacity=-2;
            }
            }
        }
        System.out.println("Maximum profit :"+max_profit);
    }
    public static void sort(float arr[], int low, int high,int profit[],int weight[])
    {
        if (low < high)
        {
            int par = partition(arr, low, high,profit,weight);
            sort(arr, low, par-1,profit,weight);
            sort(arr, par+1, high,profit,weight);
        }
    }
    public static int partition(float arr[], int low, int high,int profit[],int weight[])
    {
        float pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                int temp2=profit[i];
                profit[i]=profit[j];
                profit[j]=temp2;
                int temp3=weight[i];
                weight[i]=weight[j];
                weight[j]=temp3;
            }
        }
        float temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        int temp2=profit[i+1];
        profit[i+1]=profit[high];
        profit[high]=temp2;
        int temp3=weight[i+1];
        weight[i+1]=weight[high];
        weight[high]=temp3;
        return i+1;
    }
}