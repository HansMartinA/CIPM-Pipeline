package dmodel.designtime.system.pcm;

import dmodel.designtime.system.pcm.data.ConnectionConflict;
import dmodel.designtime.system.pcm.impl.PCMSystemBuilder;

/**
 * Listener for conflicts that are generated by the {@link PCMSystemBuilder}
 * when there are mutliple components available for the same required role.
 * 
 * @author David Monschein
 *
 */
public interface IConnectionConflictListener {

	/**
	 * Called when a conflict occurs.
	 * 
	 * @param conflict the conflict
	 */
	public void conflict(ConnectionConflict conflict);

}
