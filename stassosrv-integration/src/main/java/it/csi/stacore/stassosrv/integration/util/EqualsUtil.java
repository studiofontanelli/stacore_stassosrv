package it.csi.stacore.stassosrv.integration.util;

import java.math.BigDecimal;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */

public class EqualsUtil {
	
	//~ Methods ==================================================================

	/**
	 * DOCUMENT ME!
	 *
	 * @param obj1 DOCUMENT ME!
	 * @param obj2 DOCUMENT ME!
	 *
	 * @return DOCUMENT ME!
	 */
	public static boolean objectEquals(Object obj1, Object obj2) {
		boolean equals = false;

		if((obj1 == null) && (obj2 == null)) {
			equals = true;
		} else if((obj1 != null) && (obj2 != null)) {
			if(obj1 instanceof BigDecimal && obj2 instanceof BigDecimal) {
				equals = ((BigDecimal) obj1).compareTo((BigDecimal) obj2) == 0;
			} else {
				equals = obj1.equals(obj2);
			}
		}

		return equals;
	}
}
