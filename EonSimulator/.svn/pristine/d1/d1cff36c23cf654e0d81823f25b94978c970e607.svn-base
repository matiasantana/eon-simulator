package br.ufpe.eonsimulator.routing;

import java.util.ArrayList;
import java.util.List;

import br.ufpe.eonsimulator.costFunctions.IsCostFunction;
import br.ufpe.eonsimulator.domain.Connection;
import br.ufpe.eonsimulator.domain.Route;
import br.ufpe.eonsimulator.domain.Topology;
import br.ufpe.simulatorkernel.domain.Link;
import edu.asu.emit.qyan.alg.control.YenTopKShortestPathsAlg;
import edu.asu.emit.qyan.alg.model.Graph;
import edu.asu.emit.qyan.alg.model.Path;
import edu.asu.emit.qyan.alg.model.abstracts.BaseVertex;

public class YenAlgorithm extends IsRoutingAlgorithm {

	private int top_k;

	public YenAlgorithm(int top_k) {
		this.top_k = top_k;
	}

	@Override
	protected List<Route> getRoutes(Connection connection, Topology topology,
			IsCostFunction costFunction) {
		Graph graph = createGraph(topology, costFunction);
		YenTopKShortestPathsAlg yenAlg = new YenTopKShortestPathsAlg(graph);
		List<Path> shortest_paths_list = yenAlg.get_shortest_paths(graph
				.get_vertex(topology.getPhysicalElementIndex(connection
						.getPhysicalElementPair().getSource())), graph
				.get_vertex(topology.getPhysicalElementIndex(connection
						.getPhysicalElementPair().getTarget())), top_k);
		List<Route> routes = toRoutes(shortest_paths_list, topology);
		graph.clear();
		return routes;
	}

	private List<Route> toRoutes(List<Path> shortest_paths_list,
			Topology topology) {
		List<Route> routes = new ArrayList<Route>();
		for (Path path : shortest_paths_list) {
			Route route = new Route();
			BaseVertex source = null;
			for (BaseVertex baseVertex : path.get_vertices()) {
				if (source != null) {
					route.addLink(topology.getLink(
							topology.getPhysicalElement(source.get_id())
									.getIndex(),
							topology.getPhysicalElement(baseVertex.get_id())
									.getIndex()));
				}
				source = baseVertex;
			}
			routes.add(route);
		}
		return routes;
	}

	private Graph createGraph(Topology topology, IsCostFunction costFunction) {
		Graph graph = new Graph();
		graph.setNumberOfVertexs(topology.getPhysicalNodes().size());
		for (Link link : topology.getLinks()) {
			graph.add_edge(
					topology.getPhysicalElementIndex(link.getSourceNode()),
					topology.getPhysicalElementIndex(link.getTargetNode()),
					costFunction.calculateCost(link));
		}
		return graph;
	}

}
