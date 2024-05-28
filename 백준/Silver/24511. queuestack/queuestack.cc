#include <bits/stdc++.h>

using namespace std;

int N; // 자료구조의 개수
int M; // 수열의 길이
deque<int> dq;
int A[100001];

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> N;

  for (int idx = 0; idx < N; idx++)
  {
    cin >> A[idx];
  }

  for (int idx = 0; idx < N; idx++)
  {
    int x;
    cin >> x;
    if (A[idx] == 0)
    {
      dq.push_back(x);
    }
  }

  cin >> M;
  for (int idx = 0; idx < M; idx++)
  {
    int y;
    cin >> y;
    dq.push_front(y);
    cout << dq.back() << " ";
    dq.pop_back();
  }

  return 0;
}