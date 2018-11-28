package cu.aotain.osmp.task.core.common;

import java.io.File;
import java.util.List;

/**
 * 监听到的文件信息
 * 
 * @author liuz@aotian.com
 * @date 2018年8月28日 下午8:05:53
 */
public class MonitorResult {
	private List<String> dirList; // 文件所在目录级别
	private String fileName;	// 文件名称
	private File verifyFile; 	// 核验文件名
	private List<File> dataFileList; 	// 数据文件列表
	private String monitorPath;
	private String dataFileNameSuffix; // 数据文件名后缀

	public String getDataFileNameSuffix() {
		return dataFileNameSuffix;
	}

	public void setDataFileNameSuffix(String dataFileNameSuffix) {
		this.dataFileNameSuffix = dataFileNameSuffix;
	}

	public String getMonitorPath() {
		return monitorPath;
	}

	public void setMonitorPath(String monitorPath) {
		this.monitorPath = monitorPath;
	}

	public File getVerifyFile() {
		return verifyFile;
	}

	public void setVerifyFile(File verifyFile) {
		this.verifyFile = verifyFile;
	}

	public List<File> getDataFileList() {
		return dataFileList;
	}

	public void setDataFileList(List<File> dataFileList) {
		this.dataFileList = dataFileList;
	}

	public List<String> getDirList() {
		return dirList;
	}

	public void setDirList(List<String> dirList) {
		this.dirList = dirList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "MonitorResult [dirList=" + dirList + ", fileName=" + fileName + ", verifyFile=" + verifyFile
				+ ", dataFileList=" + dataFileList + ", monitorPath=" + monitorPath + ", dataFileNameSuffix="
				+ dataFileNameSuffix + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFileList == null) ? 0 : dataFileList.hashCode());
		result = prime * result + ((dataFileNameSuffix == null) ? 0 : dataFileNameSuffix.hashCode());
		result = prime * result + ((dirList == null) ? 0 : dirList.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((monitorPath == null) ? 0 : monitorPath.hashCode());
		result = prime * result + ((verifyFile == null) ? 0 : verifyFile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonitorResult other = (MonitorResult) obj;
		if (dataFileList == null) {
			if (other.dataFileList != null)
				return false;
		} else if (!dataFileList.equals(other.dataFileList))
			return false;
		if (dataFileNameSuffix == null) {
			if (other.dataFileNameSuffix != null)
				return false;
		} else if (!dataFileNameSuffix.equals(other.dataFileNameSuffix))
			return false;
		if (dirList == null) {
			if (other.dirList != null)
				return false;
		} else if (!dirList.equals(other.dirList))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (monitorPath == null) {
			if (other.monitorPath != null)
				return false;
		} else if (!monitorPath.equals(other.monitorPath))
			return false;
		if (verifyFile == null) {
			if (other.verifyFile != null)
				return false;
		} else if (!verifyFile.equals(other.verifyFile))
			return false;
		return true;
	}

}
