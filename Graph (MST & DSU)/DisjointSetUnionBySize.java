import java.util.*;
class DisjointSetUnionBySize{
	List<Integer> size = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	public DisjointSetUnionBySize(int n){
		for(int i=0; i<=n; i++){
			size.add(1);
			parent.add(i);
		}
	}

	public int findUpar(int node){
		if(node == parent.get(node)) return node; //ultimate parent

		int ulp = findUpar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionBySize(int u, int v){
		int ulp_u = findUpar(u);
		int ulp_v = findUpar(v);
		if(ulp_u == ulp_v) return;
		if(size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
		}
		else{
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
	public static void main(String[] args){
		DisjointSetUnionBySize solution = new DisjointSetUnionBySize(7);

		solution.unionBySize(1, 2);
		solution.unionBySize(2, 3);
		solution.unionBySize(4, 5);
		solution.unionBySize(6, 7);
		solution.unionBySize(5, 6);

		//if 3 & 7 belong to the same component or not
		if(solution.findUpar(3) == solution.findUpar(7)){
			System.out.println("Same");
		}
		else{
			System.out.println("Not same");
		}

		solution.unionBySize(3, 7);
		if(solution.findUpar(3) == solution.findUpar(7)){
			System.out.println("Same");
		}
		else{
			System.out.println("Not same");
		}
		return;
	}
}