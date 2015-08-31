package br.ufpe.eonsimulator.routing;

import java.util.List;

import br.ufpe.eonsimulator.costFunctions.IsCostFunction;
import br.ufpe.eonsimulator.domain.Connection;
import br.ufpe.eonsimulator.domain.Route;
import br.ufpe.eonsimulator.domain.Topology;

public class Surballe extends IsRoutingAlgorithm {

	/*
	 * public enum ProtectionType { FULL, //The work and protection routes need
	 * to be deployed. JUSTWORK //Just work route needs to be deployed. }
	 */
	
	/**
	 * Returns one pair of disjoint routes.
	 */
	@Override
	public List<Route> getRoutes(Connection connection, Topology topology,
			IsCostFunction costFunction) {

		/*
		 * Dijkstra dijkstra = new Dijkstra();
		 * 
		 * // Find the cheapest route (R1). Route route1 =
		 * dijkstra.getRoutes(connection, topology, costFunction) .get(0);
		 * 
		 * // Remove the links of the cheapest route (just uplink). Topology
		 * topWithoutR1 = removeUpLinks(route1, topology);
		 * 
		 * // Find the cheapest route without the links of the R1 (R2). Route
		 * route2 = dijkstra.getRoutes(connection, topWithoutR1,
		 * costFunction).get(0);
		 * 
		 * // Remove the links common to R1 and R2. Topology topWithoutEqLinks =
		 * removeEqualLinks(route1, route2, topology);
		 * 
		 * // Find the work route. Route workRoute =
		 * dijkstra.getRoutes(connection, topWithoutEqLinks,
		 * costFunction).get(0);
		 * 
		 * // Remove the links of work route. Topology topWithoutW1 =
		 * removeLinks(workRoute, topWithoutEqLinks);
		 * 
		 * // Find the protection route.
		 * 
		 * Route protectionRoute = dijkstra.getRoutes(connection, topWithoutW1,
		 * costFunction).get(0);
		 * 
		 * // Define protection route and work route.
		 * workRoute.setProtectionRoute(protectionRoute);
		 * 
		 * ArrayList<Route> temp = new ArrayList<Route>(); temp.add(workRoute);
		 * 
		 * return temp;
		 */return null;
	}

	/*
	 * private Topology removeLinks(Route route, Topology topology) { return
	 * removeLinks(route, topology, true); }
	 */
	/*
	 * private Topology removeEqualLinks(Route route1, Route route2, Topology
	 * topology) {
	 * 
	 * ArrayList<Link> equalLinks = new ArrayList<Link>(); for (Link l1 :
	 * route1.getLinks()) { for (Link l2 : route2.getLinks()) { if
	 * (l1.equals(l2) || inverseLink(l1).equals(l2)) { equalLinks.add(l1); } } }
	 * 
	 * Route fakeRoute = new Route(); fakeRoute.setLinks(equalLinks);
	 * 
	 * return removeLinks(fakeRoute, topology); }
	 * 
	 * private Topology removeUpLinks(Route route, Topology topology) { return
	 * removeLinks(route, topology, false); }
	 * 
	 * private Topology removeLinks(Route route, Topology topology, boolean
	 * downLink) {
	 * 
	 * Topology temp = topology.clone();
	 * 
	 * List<Link> links = route.getLinks(); for (int i = 0; i < links.size();
	 * i++) { Link l = links.get(i); temp.removeLink(l); // upLink
	 * 
	 * if (downLink) { // temp.removeLink(l.getDestinationNode(),
	 * l.getSourceNode()); // // downLink
	 * 
	 * // if (i < links.size() - 1) // Does not remove the // source/destination
	 * node of the // route // temp.removeNode(l.getSourceNode()); } }
	 * 
	 * return temp;
	 * 
	 * return null; }
	 * 
	 * private Link inverseLink(Link link) { // Link temp = link.clone();
	 * 
	 * // temp.setDestinationNode(link.getSourceNode()); //
	 * temp.setSourceNode(link.getDestinationNode());
	 * 
	 * // return temp; return null; }
	 */
}
