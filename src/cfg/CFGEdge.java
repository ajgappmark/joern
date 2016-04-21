package cfg;

import java.util.HashMap;
import java.util.Map;

import cfg.nodes.CFGNode;
import graphutils.Edge;

public class CFGEdge extends Edge<CFGNode>
{

	public static final String EMPTY_LABEL = "";
	public static final String TRUE_LABEL = "True";
	public static final String FALSE_LABEL = "False";
	public static final String EXCEPT_LABEL = "except";
	public static final String HANDLED_EXCEPT_LABEL = "catch";
	public static final String UNHANDLED_EXCEPT_LABEL = "unhandled";

	private String label;
	private Map<String, Object> properties;

	public CFGEdge(CFGNode source, CFGNode destination, String label)
	{
		super(source, destination);
		this.label = label;
	}

	public String getLabel()
	{
		return this.label;
	}

	@Override
	public Map<String, Object> getProperties()
	{
		if (this.properties == null)
		{
			this.properties = new HashMap<String, Object>();
			this.properties.put("flowLabel", label);
		}
		return this.properties;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!super.equals(obj))
		{
			return false;
		}
		if (!(obj instanceof CFGEdge))
		{
			return false;
		}
		CFGEdge other = (CFGEdge) obj;
		if (label == null)
		{
			if (other.label != null)
			{
				return false;
			}
		}
		else if (!label.equals(other.label))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return getSource() + " ==[" + getLabel() + "]==> " + getDestination();
	}

	@Override
	public CFGEdge reverse()
	{
		return new CFGEdge(getDestination(), getSource(), getLabel());

	}

}
