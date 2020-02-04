package DailyCoding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode690 {

    class Employee {

        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public static void main(String[] args) {

    }

    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee e :
                employees) {
            emap.put(e.id, e);
        }
        return dfs(id);
    }

    public int dfs(int eid) { //一个ID进来
        Employee employee = emap.get(eid);  //通过这个ID得到这个类
        int ans = employee.importance;  //得到这个员工的重要度
        for (Integer subid:
             employee.subordinates) {
            ans += dfs(subid);  //深度搜索
        }
        return ans;
    }
}