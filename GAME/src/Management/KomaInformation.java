package Management;

import java.awt.event.MouseAdapter;

import Datacollection.BaseFileNameCollection;
import Datacollection.BaseParameterCollection;

public class KomaInformation {
	private MouseAdapter mouseAdapter;
	private BaseFileNameCollection fileNameCollection;
	private BaseParameterCollection parameterCollection;
	private boolean firstSecond;

	public KomaInformation(MouseAdapter _mouseAdapter, BaseFileNameCollection _fileNameCollection,
			               BaseParameterCollection _pointCollection, boolean _firstSecond) {
		mouseAdapter = _mouseAdapter;
		fileNameCollection = _fileNameCollection;
		parameterCollection = _pointCollection;
		firstSecond = _firstSecond;
	}
	public MouseAdapter getMouseAdapter() {
		return mouseAdapter;
	}
	public BaseFileNameCollection getFileNameCollection() {
		return fileNameCollection;
	}
	public BaseParameterCollection getPointCollection() {
		return parameterCollection;
	}
	public boolean getFirstSecond() {
		return firstSecond;
	}

}
