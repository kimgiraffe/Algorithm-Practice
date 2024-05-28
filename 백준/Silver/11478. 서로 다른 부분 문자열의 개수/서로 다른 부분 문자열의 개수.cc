#include <bits/stdc++.h>
using namespace std;

string str;

set<string> s;

int main()
{
  cin >> str;
  for (int i = 0; i < str.length(); i++)
  {
    for (int j = 0; j < str.length(); j++)
    {
      s.insert(str.substr(i, j - i));
    }
  }

  cout << s.size();

  return 0;
}