/*int countDigits(int n){
	string s = to_string(n);
	string sub = "";
	for (char c : s) {
		int s_n = stoi(string(1,c));
		if (s_n == 0) {
			sub += c; 
			continue;
		}
		if (n % s_n == 0) {
			if (sub.find(string(1, c)) == string::npos){
				sub += c;
			}
		}
	}
	return sub.length();
}
*/

/*int countDigits(int n) {
	int m = n;
	int c = 0;
	int dig;
	while (m > 0) {
		dig = m % 10;
		m /= 10;
		if (dig == 0) {continue;}
		if (n % dig == 0) {
			c++;
		}
	}
	return c;
}*/
