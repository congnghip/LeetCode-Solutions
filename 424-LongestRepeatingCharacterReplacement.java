class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxfreq = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++)
        {
            // kiểm tra và tăng kí tự trong bản chử cái
            freq[s.charAt(right) - 'A']++;
            // lấy kí tự đang xuất hiện nhiều nhất
            maxfreq = Math.max(maxfreq,freq[s.charAt(right) - 'A']);
            // xem cửa sổ đang trược đên đâu 
            int window = right - left + 1;
            // lấy cửa sổ trừ số lượng xuất hiện thì ra số lượng cần đổi
            if (window - maxfreq > k)
            {
                // giảm kí tự tại vị trí đầu
                freq[s.charAt(left) - 'A']--;
                // thu hẹp cửa xổ từ từ
                left++;
            }
            // tính toán lại window
            window = right - left + 1;
            max = Math.max(max,window);
        }
        return max;
    }
}