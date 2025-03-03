import java.util.*;
class DisjointSetUnionByRank{
	// List<Integer> rank = new ArrayList<>();
	// List<Integer> parent = new ArrayList<>();
	// public DisjointSetUnionByRank(int n){
	// 	for(int i=0; i<=n; i++){
	// 		rank.add(0);
	// 		parent.add(i);
	// 	}
	// }

	// public int findUpar(int node){
	// 	if(node == parent.get(node)) return node; //ultimate parent

	// 	int ulp = findUpar(parent.get(node));
	// 	parent.set(node, ulp);
	// 	return parent.get(node);
	// }

	// public void unionByRank(int u, int v){
	// 	int ulp_u = findUpar(u);
	// 	int ulp_v = findUpar(v);
	// 	if(ulp_u == ulp_v) return; // they belong to same component
	// 	//else
	// 	if(rank.get(ulp_u) < rank.get(ulp_v)){
	// 		parent.set(ulp_u, ulp_v);
	// 		//no change in rank cuz when smaller gets attached with larger the rank or size will remain the same
	// 	}
	// 	else if(rank.get(ulp_v) < rank.get(ulp_u)){
	// 		parent.set(ulp_v, ulp_u);
	// 		//no change in rank cuz when smaller gets attached with larger the rank or size will remain the same
	// 	}
	// 	else{
	// 		//rank same

	// 		parent.set(ulp_v, ulp_u); // connect either one of the components with eachother
	// 		//parent.set(ulp_u, ulp_v) 
	// 		int rankU = rank.get(ulp_u); //get the rank of either one of them they will be same
	// 		rank.set(ulp_u, rankU + 1); //add rank
	// 	}
	// }
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();

	public DisjointSetUnionByRank(int n){
		for(int i=0; i<=n; i++){
			parent.add(i);
			rank.add(0);
		}
	}

	public int findUltimateParent(int node){
		if(node == parent.get(node)) return node;

		int ultimateParent = findUltimateParent(parent.get(node));
		parent.set(node, ultimateParent);
		return parent.get(node);
	}

	public void unionByRank(int u, int v){
		int ultimateParent_u = findUltimateParent(u);
		int ultimateParent_v = findUltimateParent(v);

		if(ultimateParent_u == ultimateParent_v) return;

		if(rank.get(ultimateParent_u) < rank.get(ultimateParent_v)){
			parent.set(ultimateParent_u, ultimateParent_v);
		}
		else if(rank.get(ultimateParent_v) < rank.get(ultimateParent_u)){
			parent.set(ultimateParent_v, ultimateParent_u);
		}
		else{
			parent.set(ultimateParent_u, ultimateParent_v);
			int newRank = 1 + rank.get(ultimateParent_v);
			rank.set(ultimateParent_v, newRank);
		}
	}
	public static void main(String[] args){
		DisjointSetUnionByRank solution = new DisjointSetUnionByRank(7);
		solution.unionByRank(1, 2);
		solution.unionByRank(2, 3);
		solution.unionByRank(4, 5);
		solution.unionByRank(6, 7);
		solution.unionByRank(5, 6);

		//if 3 & 7 belong to the same component or not
		if(solution.findUltimateParent(3) == solution.findUltimateParent(7)){
			System.out.println("Same");
		}
		else{
			System.out.println("Not same");
		}

		solution.unionByRank(3, 7);
		if(solution.findUltimateParent(3) == solution.findUltimateParent(7)){
			System.out.println("Same");
		}
		else{
			System.out.println("Not same");
		}
		return;
	}
}
