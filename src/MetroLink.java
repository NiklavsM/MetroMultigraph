
public class MetroLink extends Edge {
	private String lineColor;
	public MetroLink(int linkId, int stationFrom, int stationTo, String lineColor) {
		super(linkId, stationFrom, stationTo);
		this.lineColor = lineColor;
	}
	public String getLineColor(){
		return lineColor;
	}
}
