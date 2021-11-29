import java.util.*;
public class JobAllot
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=0,m=0,cost=0;
        System.out.println("Enter number of jobs:");
        n=sc.nextInt();
        int d[]=new int[n];
        int profit[]=new int[n];
        int rank[]=new int[n];
        int place[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter deadline and profit for Job:"+(i+1));
            d[i]=sc.nextInt();
            profit[i]=sc.nextInt();
            if(m<d[i])
            {
                m=d[i];
            }
            place[i]=i+1;
        }
        sort(profit,0,n-1,d,rank,place);
        int sequence[]=new int[m];
        for(int i=0;i<m;i++)
        {
            sequence[i]=0;
        }
        for(int i=n-1;i>=0;i--)
        {
            int j=d[i]-1;
            while(j>=0)
            {
                if(sequence[j]==0)
                {
                    sequence[j]=place[i];
                    cost=cost+profit[i];
                    break;
                }
                else j--;
            }
        }
        for(int i=0;i<m;i++)
        {
            System.out.println(sequence[i]+" ");
        }
        System.out.println("Total Profit is :"+cost);
    }
    public static void sort(int arr[], int low, int high,int d[],int rank[],int place[])
    {
        if (low < high)
        {
            int par = partition(arr, low, high,d,rank,place);
            sort(arr, low, par-1,d,rank,place);
            sort(arr, par+1, high,d,rank,place);
        }
    }
    public static int partition(int arr[], int low, int high,int d[],int rank[],int place[])
    {
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                int temp2=d[i];
                d[i]=d[j];
                d[j]=temp2;
                int temp3=rank[i];
                rank[i]=rank[j];
                rank[j]=temp3;
                int temp4=place[i];
                place[i]=place[j];
                place[j]=temp4;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        int temp2=d[i+1];
        d[i+1]=d[high];
        d[high]=temp2;
        int temp3=rank[i+1];
        rank[i+1]=rank[high];
        rank[high]=temp3;
        int temp4=place[i+1];
        place[i+1]=place[high];
        place[high]=temp4;
        return i+1;
    }
    
}
