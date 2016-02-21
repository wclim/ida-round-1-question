#include <iostream>
#include <string>
#include <vector>

using namespace std;

void print1DArray(vector<int> print){
	for (int i=0; i< print.size(); i++){
		cout << print.at(i);
		if (i < print.size()-1){
			cout << " ";
		}else{
			cout << endl;
		}
	}
	
}

int findMatch(vector<int> seq){
	int match=0;
	for (int i=0;i<seq.size(); i++){
		if(i+1==seq.at(i)){
			match++;
		}
	}
	return match;
}

vector<int> getBestSeq(vector<int> seq){
	vector<int> currBestMatch;
	int currBestMatchSize = -1, currMatchSize;
	for (int i=0; i<=seq.size(); i++){
		currMatchSize = findMatch(seq);
		if(currBestMatchSize < currMatchSize){
			currBestMatchSize = currMatchSize;
			currBestMatch.resize(seq.size());
			copy(seq.begin(), seq.end(), currBestMatch.begin());
		}
		seq.push_back(*(seq.begin()));
		seq.erase(seq.begin());
	}
	return currBestMatch;
}

int main()
{
    int numTest;
    cin >> numTest;
    int n=0;
    if (numTest>1000){
    	return 0;
    }
    for (int i=1; i<=numTest; i++){
    	cin >> n;
    	vector<int> seq;
    	int inputInt;
    		for (int j=0; j<n; j++){
    			cin >> inputInt;
    			seq.push_back(inputInt);
    		}
    		print1DArray(getBestSeq(seq));
    }
    return 0;
}

