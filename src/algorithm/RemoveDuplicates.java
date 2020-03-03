package algorithm;

import java.util.HashSet;

public class RemoveDuplicates {

    /**
     * 删除排序数组中的重复项
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 方法：双指针法
     *
     * 数组完成排序后，我们可以放置两个指针i和j，其中i是慢指针，而j是快指针。只要 nums[i] = nums[j]，我们就增加j以跳过重复项。
     *
     * 当我们遇到 nums[j] != nums[i]时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到nums[i+1]。然后递增i，接着我们将再次重复相同的过程，直到j到达数组的末尾为止。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 删除排序数组中的重复项
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定 nums = [1,1,1,2,2,3],
     *
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     *
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 算法：
     *
     * 1.我们使用了两个指针，i 是遍历指针，指向当前遍历的元素；j 指向下一个要覆盖元素的位置。
     * 2.同样，我们用 count 记录当前数字出现的次数。count 的最小计数始终为 1。
     * 3.我们从索引 1 开始一次处理一个数组元素。
     * 4.若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。在这种情况下，我们只向前移动 i，而 j 不动。
     * 5.若 count <=2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
     * 6.若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
     * 7.当数组遍历完成，则返回 j。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-i-7/
     * @param nums
     * @return
     */
    private static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    /**
     * 删除字符串中的所有相邻重复项
     *
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。
     *
     * 示例：
     *
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     *
     * 方法一：替换函数
     * 我们可以用字符串自带的替换函数，由于字符串仅包含小写字母，因此只有 26 种不同的重复项。
     *
     * 将 aa 到 zz 的 26 种重复项放入集合中；
     *
     * 遍历这 26 种重复项，并用字符串的替换函数把重复项替换成空串。
     *
     * 注意，在进行过一次替换之后，可能会出现新的重复项。例如对于字符串 abbaca，如果替换了重复项 bb，字符串会变为 aaca，出现了新的重复项 aa。因此，上面的过程需要背重复若干次，直到字符串在一整轮替换过程后保持不变（即长度不变）为止。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin-zh/
     * @param S
     * @return
     */
    private static String removeDuplicateChar(String S) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            sb.setLength(0);
            sb.append(i);
            sb.append(i);
            set.add(sb.toString());
        }
        int prevLength = -1;
        while (prevLength != S.length()) {
            prevLength = S.length();
            for (String str : set) {
                S = S.replace(str, "");
            }
        }
        return S;
    }

    /**
     * 方法二：栈
     * 我们可以用栈来维护没有重复项的字母序列：
     *
     * 若当前的字母和栈顶的字母相同，则弹出栈顶的字母；
     *
     * 若当前的字母和栈顶的字母不同，则放入当前的字母。
     *
     * @param S
     * @return
     */
    private static String removeDuplicateChar1(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength -= 1;
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicateChar1("labbalcde"));
    }
}
