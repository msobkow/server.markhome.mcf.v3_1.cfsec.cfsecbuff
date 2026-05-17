// Description: Java 25 implementation of a SecSysRoleEnables primary key buffer object

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsec.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

/*
 *	CFSecBuffSecSysRoleEnablesPKey Primary Key for SecSysRoleEnables buffers
 *		requiredSecSysRoleId	Required object attribute SecSysRoleId.
 *		requiredEnableName	Required object attribute EnableName.
 */
public class CFSecBuffSecSysRoleEnablesPKey
	implements ICFSecSecSysRoleEnablesPKey, Comparable<ICFSecSecSysRoleEnablesPKey>, Serializable
{
	protected CFLibDbKeyHash256 requiredSecSysRoleId;
	protected String requiredEnableName;

	public CFSecBuffSecSysRoleEnablesPKey() {
		requiredSecSysRoleId = CFLibDbKeyHash256.fromHex( ICFSecSecSysRoleEnables.SECSYSROLEID_INIT_VALUE.toString() );
		requiredEnableName = ICFSecSecSysRoleEnables.ENABLENAME_INIT_VALUE;
	}

	@Override
	public ICFSecSecSysRole getRequiredContainerSysRole() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerSysRole", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecSysRoleTable targetTable = targetBackingSchema.getTableSecSysRole();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerSysRole", 0, "ICFSecSchema.getBackingCFSec().getTableSecSysRole()");
		}
		ICFSecSecSysRole targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredSecSysRoleId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerSysRole(ICFSecSecSysRole argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerSysRole", 1, "argObj");
		}
		else {
			requiredSecSysRoleId = argObj.getRequiredSecSysRoleId();
		}
	
	}

	@Override
	public void setRequiredContainerSysRole(CFLibDbKeyHash256 argSecSysRoleId) {
		requiredSecSysRoleId = argSecSysRoleId;
	}
	@Override
	public ICFSecSecSysGrp getRequiredParentEnableGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentEnableGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecSysGrpTable targetTable = targetBackingSchema.getTableSecSysGrp();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentEnableGroup", 0, "ICFSecSchema.getBackingCFSec().getTableSecSysGrp()");
		}
		ICFSecSecSysGrp targetRec = targetTable.readDerivedByUNameIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredEnableName());
		return(targetRec);
	}
	@Override
	public void setRequiredParentEnableGroup(ICFSecSecSysGrp argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setParentEnableGroup", 1, "argObj");
		}
		else {
			requiredEnableName = argObj.getRequiredName();
		}
	
	}

	@Override
	public void setRequiredParentEnableGroup(String argEnableName) {
		requiredEnableName = argEnableName;
	}
	@Override
	public CFLibDbKeyHash256 getRequiredSecSysRoleId() {
		return( requiredSecSysRoleId );
	}

	@Override
	public String getRequiredEnableName() {
		return( requiredEnableName );
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof ICFSecSecSysRoleEnablesPKey) {
			ICFSecSecSysRoleEnablesPKey rhs = (ICFSecSecSysRoleEnablesPKey)obj;
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getRequiredSecSysRoleId().hashCode();
		if( getRequiredEnableName() != null ) {
			hashCode = hashCode + getRequiredEnableName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( ICFSecSecSysRoleEnablesPKey rhs ) {
		int cmp;
		if (rhs == null) {
			return( 1 );
		}
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
		return( 0 );
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredSecSysRoleId=" + "\"" + getRequiredSecSysRoleId().toString() + "\""
			+ " RequiredEnableName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEnableName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecSecSysRoleEnablesPKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
