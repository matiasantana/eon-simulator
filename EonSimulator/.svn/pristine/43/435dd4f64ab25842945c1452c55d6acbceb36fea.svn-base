package br.ufpe.eonsimulator.domain;

import java.util.List;

public class LinksCostWrapper implements Comparable<LinksCostWrapper> {

	private double maxCost;
	private List<String> linksCosts;

	public LinksCostWrapper(double maxCost, List<String> linksCosts) {
		super();
		this.maxCost = maxCost;
		this.linksCosts = linksCosts;
	}

	@Override
	public int compareTo(LinksCostWrapper o) {
		if (maxCost < o.maxCost) {
			return -1;
		} else if (maxCost > o.maxCost) {
			return 1;
		} else {
			return 0;
		}
	}

	public double getMaxCost() {
		return maxCost;
	}

	public List<String> getLinksCosts() {
		return linksCosts;
	}

}
