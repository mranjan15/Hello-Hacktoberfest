package AdobeMockTest;

import DSAUDemy.Graph.graphTraversal;
import java.util.*;
import java.util.Objects;

class ExpertGroup {

  String expert;
  String language;

  ExpertGroup(String expert, String language) {
    this.expert = expert;
    this.language = language;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;

    if (o == null || o.getClass() != this.getClass()) return false;

    ExpertGroup other = (ExpertGroup) o;

    return (
      this.expert.equals(other.expert) && this.language.equals(other.language)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(expert, language);
  }
}

public class MatchMacking {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<ExpertGroup, Integer> groups = new HashMap<ExpertGroup, Integer>();

    for (int i = 0; i < 4; i++) {
      String str[] = sc.nextLine().split(" ");
      ExpertGroup grp = new ExpertGroup(str[0], str[1]);
      groups.put(grp, groups.getOrDefault(grp, 0) + 1);
    }

    HashMap<ExpertGroup, Integer> customers = new HashMap<ExpertGroup, Integer>();

    for (int i = 0; i < 4; i++) {
      String str[] = sc.nextLine().split(" ");
      ExpertGroup grp = new ExpertGroup(str[0], str[1]);
      customers.put(grp, customers.getOrDefault(grp, 0) + 1);
    }

    /*
    tax spanish
tax spanish
tax english
crypto hindi
crypto english
tax english
sf spanish
sf spanish 
*/
    int ans = 0;
    for (Map.Entry<ExpertGroup, Integer> entry : customers.entrySet()) {
      if (
        groups.containsKey(entry.getKey()) && groups.get(entry.getKey()) != 0
      ) {
        groups.replace(entry.getKey(), entry.getValue() - 1);
      } else if (!groups.containsKey(entry.getKey())) {
        ans += entry.getValue();
      } else {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
