#include <bits/stdc++.h>

using namespace std;

int main()
{
  int answer = 0;
  string doc;
  string search;
  getline(cin, doc);
  getline(cin, search);

  for (int i = 0; i < doc.length(); i++)
  {
    bool isEqual = true;
    for (int j = 0; j < search.length(); j++)
    {
      if (doc[i + j] != search[j])
      {
        isEqual = false;
        break;
      }
    }
    if (isEqual)
    {
      answer++;
      i += search.length() - 1;
    }
  }

  cout << answer;

  return 0;
}
