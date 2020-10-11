#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
#include <map>
#include <stack>
#include <queue>
#include <list>
using namespace std;

int N, M;
vector<pair<int, pair<int, int>>> v;
string answer;
string s;
bool h;

struct mystruct{
  int start;
  int end;
  char type;
};

class Graph
{
    int V;

    // Pointer to an array containing
    // adjacency lists
    list<int> *adj;

    // A recursive function used by DFS
    bool DFSUtil(int v, bool visited[], int end, char c, int path[], int &path_index);

    public:
    Graph(int V);   // Constructor

    // function to add an edge to graph
    void addEdge(int v, int w);

    // DFS traversal of the vertices
    // reachable from v
    void DFS(int v, int end, char type);
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w); // Add w to v’s list.
}

bool Graph::DFSUtil(int v, bool visited[], int end, char type, int path[], int &path_index)
{
    // Mark the current node as visited and
    // print it
    visited[v] = true;
    path[path_index]=v;
    path_index++;

    //cout << v<<s[v]<<endl;
    //if (s[v]==type) {h=1; return;}
    if (v==end) {
         for(int i=0; i<path_index; i++){
            //cout << path[i]+1 << " ";
            if (s[path[i]]==type) h=1;
         }
         //cout << endl;
    }
    else {
        list<int>::iterator i;
        for (i = adj[v].begin(); i != adj[v].end(); ++i)
            if (!visited[*i] )
            DFSUtil(*i, visited, end, type, path, path_index);
    }
    path_index--;
    visited[v]=false;
}

// DFS traversal of the vertices reachable from v.
// It uses recursive DFSUtil()
void Graph::DFS(int v, int end, char type)
{
    // Mark all the vertices as not visited
    bool *visited = new bool[V];
    bool find=false;

    int *path = new int[10000];
    int path_index = 0;
    for (int i = 0; i < V; i++)
        visited[i] = false;

    // Call the recursive helper function
    // to print DFS traversal
    if (!find) find=DFSUtil(v, visited, end, type, path, path_index);
}

// Driver code
int main()
{
    int a, b;
    char c, temp;
    ifstream fin("milkvisits.in");
    ofstream fout("milkvisits.out");
    fin >> N >> M;
    //cout << N << M <<"\n";
    for (int i = 0; i<N; i++){
        fin >> temp;
        s+=temp;
    }

    Graph g(N);
    cout << N << endl;
    for (int i = 0; i< N-1; i++){
       fin >> a >> b;
       cout << a << " " << b << "\n";
       g.addEdge(a-1, b-1);
       g.addEdge(b-1, a-1);
    }

    for (int i = 0; i < M; i++){
        h=0;
       fin >> a >> b >> c;
       g.DFS(a-1, b-1, c);
       fout<<h;
    }
    fout<<endl;
    /*answer.push_back('0');
    ofstream fout("milkvisits.out");
    fout << answer << "\n";
    */return 0;
}


