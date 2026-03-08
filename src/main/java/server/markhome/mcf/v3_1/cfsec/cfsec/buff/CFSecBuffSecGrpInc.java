// Description: Java 25 implementation of a SecGrpInc buffer

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	This file is part of Mark's Code Fractal CFSec.
 *	
 *	Mark's Code Fractal CFSec is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFSec is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFSec is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFSec.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
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

public class CFSecBuffSecGrpInc
	implements ICFSecSecGrpInc, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredSecGrpIncId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecGrpInc.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecGrpInc.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 requiredClusterId;
	protected CFLibDbKeyHash256 requiredSecGroupId;
	protected CFLibDbKeyHash256 requiredIncludeGroupId;

	public CFSecBuffSecGrpInc() {
		requiredSecGrpIncId = CFLibDbKeyHash256.fromHex( ICFSecSecGrpInc.SECGRPINCID_INIT_VALUE.toString() );
		requiredClusterId = CFLibDbKeyHash256.fromHex( ICFSecSecGrpInc.CLUSTERID_INIT_VALUE.toString() );
		requiredSecGroupId = CFLibDbKeyHash256.fromHex( ICFSecSecGrpInc.SECGROUPID_INIT_VALUE.toString() );
		requiredIncludeGroupId = CFLibDbKeyHash256.fromHex( ICFSecSecGrpInc.INCLUDEGROUPID_INIT_VALUE.toString() );
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredSecGrpIncId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredSecGrpIncId) {
		if (requiredSecGrpIncId != null) {
			setRequiredSecGrpIncId(requiredSecGrpIncId);
		}
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecGrpIncId() {
		return( requiredSecGrpIncId );
	}

	@Override
	public void setRequiredSecGrpIncId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecGrpIncId",
				1,
				"value" );
		}
		requiredSecGrpIncId = value;
	}

	@Override
	public CFLibDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public CFLibDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}
	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFSecSecGrpInc.CLASS_CODE );
	}

	@Override
	public ICFSecCluster getRequiredOwnerCluster() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerCluster", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecClusterTable targetTable = targetBackingSchema.getTableCluster();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerCluster", 0, "ICFSecSchema.getBackingCFSec().getTableCluster()");
		}
		ICFSecCluster targetRec = targetTable.readDerived(null, getRequiredClusterId());
		return(targetRec);
	}
	@Override
	public void setRequiredOwnerCluster(ICFSecCluster argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setOwnerCluster", 1, "argObj");
		}
		else {
			requiredClusterId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredOwnerCluster(CFLibDbKeyHash256 argClusterId) {
		requiredClusterId = argClusterId;
	}

	@Override
	public ICFSecSecGroup getRequiredContainerGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecGroupTable targetTable = targetBackingSchema.getTableSecGroup();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerGroup", 0, "ICFSecSchema.getBackingCFSec().getTableSecGroup()");
		}
		ICFSecSecGroup targetRec = targetTable.readDerived(null, getRequiredSecGroupId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerGroup(ICFSecSecGroup argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerGroup", 1, "argObj");
		}
		else {
			requiredSecGroupId = argObj.getRequiredSecGroupId();
		}
	}

	@Override
	public void setRequiredContainerGroup(CFLibDbKeyHash256 argSecGroupId) {
		requiredSecGroupId = argSecGroupId;
	}

	@Override
	public ICFSecSecGroup getRequiredParentSubGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentSubGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecGroupTable targetTable = targetBackingSchema.getTableSecGroup();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentSubGroup", 0, "ICFSecSchema.getBackingCFSec().getTableSecGroup()");
		}
		ICFSecSecGroup targetRec = targetTable.readDerived(null, getRequiredIncludeGroupId());
		return(targetRec);
	}
	@Override
	public void setRequiredParentSubGroup(ICFSecSecGroup argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setParentSubGroup", 1, "argObj");
		}
		else {
			requiredIncludeGroupId = argObj.getRequiredSecGroupId();
		}
	}

	@Override
	public void setRequiredParentSubGroup(CFLibDbKeyHash256 argIncludeGroupId) {
		requiredIncludeGroupId = argIncludeGroupId;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredClusterId() {
		return( requiredClusterId );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecGroupId() {
		return( requiredSecGroupId );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredIncludeGroupId() {
		return( requiredIncludeGroupId );
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecSecGrpInc ) {
			ICFSecSecGrpInc rhs = (ICFSecSecGrpInc)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredSecGrpIncId() != null ) {
				if( rhs.getRequiredSecGrpIncId() != null ) {
					if( ! getRequiredSecGrpIncId().equals( rhs.getRequiredSecGrpIncId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGrpIncId() != null ) {
					return( false );
				}
			}
			if( getRequiredClusterId() != null ) {
				if( rhs.getRequiredClusterId() != null ) {
					if( ! getRequiredClusterId().equals( rhs.getRequiredClusterId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClusterId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecGroupId() != null ) {
				if( rhs.getRequiredSecGroupId() != null ) {
					if( ! getRequiredSecGroupId().equals( rhs.getRequiredSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGroupId() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeGroupId() != null ) {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					if( ! getRequiredIncludeGroupId().equals( rhs.getRequiredIncludeGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecGrpIncH ) {
			ICFSecSecGrpIncH rhs = (ICFSecSecGrpIncH)obj;
			if( getRequiredSecGrpIncId() != null ) {
				if( rhs.getRequiredSecGrpIncId() != null ) {
					if( ! getRequiredSecGrpIncId().equals( rhs.getRequiredSecGrpIncId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGrpIncId() != null ) {
					return( false );
				}
			}
			if( getRequiredClusterId() != null ) {
				if( rhs.getRequiredClusterId() != null ) {
					if( ! getRequiredClusterId().equals( rhs.getRequiredClusterId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClusterId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecGroupId() != null ) {
				if( rhs.getRequiredSecGroupId() != null ) {
					if( ! getRequiredSecGroupId().equals( rhs.getRequiredSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGroupId() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeGroupId() != null ) {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					if( ! getRequiredIncludeGroupId().equals( rhs.getRequiredIncludeGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecGrpIncHPKey ) {
			ICFSecSecGrpIncHPKey rhs = (ICFSecSecGrpIncHPKey)obj;
			if( getRequiredSecGrpIncId() != null ) {
				if( rhs.getRequiredSecGrpIncId() != null ) {
					if( ! getRequiredSecGrpIncId().equals( rhs.getRequiredSecGrpIncId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGrpIncId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecGrpIncByClusterIdxKey ) {
			ICFSecSecGrpIncByClusterIdxKey rhs = (ICFSecSecGrpIncByClusterIdxKey)obj;
			if( getRequiredClusterId() != null ) {
				if( rhs.getRequiredClusterId() != null ) {
					if( ! getRequiredClusterId().equals( rhs.getRequiredClusterId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClusterId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecGrpIncByGroupIdxKey ) {
			ICFSecSecGrpIncByGroupIdxKey rhs = (ICFSecSecGrpIncByGroupIdxKey)obj;
			if( getRequiredSecGroupId() != null ) {
				if( rhs.getRequiredSecGroupId() != null ) {
					if( ! getRequiredSecGroupId().equals( rhs.getRequiredSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecGrpIncByIncludeIdxKey ) {
			ICFSecSecGrpIncByIncludeIdxKey rhs = (ICFSecSecGrpIncByIncludeIdxKey)obj;
			if( getRequiredIncludeGroupId() != null ) {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					if( ! getRequiredIncludeGroupId().equals( rhs.getRequiredIncludeGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecGrpIncByUIncludeIdxKey ) {
			ICFSecSecGrpIncByUIncludeIdxKey rhs = (ICFSecSecGrpIncByUIncludeIdxKey)obj;
			if( getRequiredClusterId() != null ) {
				if( rhs.getRequiredClusterId() != null ) {
					if( ! getRequiredClusterId().equals( rhs.getRequiredClusterId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClusterId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecGroupId() != null ) {
				if( rhs.getRequiredSecGroupId() != null ) {
					if( ! getRequiredSecGroupId().equals( rhs.getRequiredSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecGroupId() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeGroupId() != null ) {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					if( ! getRequiredIncludeGroupId().equals( rhs.getRequiredIncludeGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredSecGrpIncId().hashCode();
		hashCode = hashCode + getRequiredClusterId().hashCode();
		hashCode = hashCode + getRequiredSecGroupId().hashCode();
		hashCode = hashCode + getRequiredIncludeGroupId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecSecGrpInc ) {
			ICFSecSecGrpInc rhs = (ICFSecSecGrpInc)obj;
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredSecGrpIncId() != null) {
				if (rhs.getRequiredSecGrpIncId() != null) {
					cmp = getRequiredSecGrpIncId().compareTo( rhs.getRequiredSecGrpIncId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGrpIncId() != null) {
				return( -1 );
			}
			if (getRequiredClusterId() != null) {
				if (rhs.getRequiredClusterId() != null) {
					cmp = getRequiredClusterId().compareTo( rhs.getRequiredClusterId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClusterId() != null) {
				return( -1 );
			}
			if (getRequiredSecGroupId() != null) {
				if (rhs.getRequiredSecGroupId() != null) {
					cmp = getRequiredSecGroupId().compareTo( rhs.getRequiredSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGroupId() != null) {
				return( -1 );
			}
			if (getRequiredIncludeGroupId() != null) {
				if (rhs.getRequiredIncludeGroupId() != null) {
					cmp = getRequiredIncludeGroupId().compareTo( rhs.getRequiredIncludeGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeGroupId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecGrpIncHPKey ) {
			ICFSecSecGrpIncHPKey rhs = (ICFSecSecGrpIncHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredSecGrpIncId() != null) {
				if (rhs.getRequiredSecGrpIncId() != null) {
					cmp = getRequiredSecGrpIncId().compareTo( rhs.getRequiredSecGrpIncId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGrpIncId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecGrpIncH ) {
			ICFSecSecGrpIncH rhs = (ICFSecSecGrpIncH)obj;
			cmp = 0;
			if (getRequiredSecGrpIncId() != null) {
				if (rhs.getRequiredSecGrpIncId() != null) {
					cmp = getRequiredSecGrpIncId().compareTo( rhs.getRequiredSecGrpIncId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGrpIncId() != null) {
				return( -1 );
			}
			if (getRequiredClusterId() != null) {
				if (rhs.getRequiredClusterId() != null) {
					cmp = getRequiredClusterId().compareTo( rhs.getRequiredClusterId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClusterId() != null) {
				return( -1 );
			}
			if (getRequiredSecGroupId() != null) {
				if (rhs.getRequiredSecGroupId() != null) {
					cmp = getRequiredSecGroupId().compareTo( rhs.getRequiredSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGroupId() != null) {
				return( -1 );
			}
			if (getRequiredIncludeGroupId() != null) {
				if (rhs.getRequiredIncludeGroupId() != null) {
					cmp = getRequiredIncludeGroupId().compareTo( rhs.getRequiredIncludeGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeGroupId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecGrpIncByClusterIdxKey ) {
			ICFSecSecGrpIncByClusterIdxKey rhs = (ICFSecSecGrpIncByClusterIdxKey)obj;

			if (getRequiredClusterId() != null) {
				if (rhs.getRequiredClusterId() != null) {
					cmp = getRequiredClusterId().compareTo( rhs.getRequiredClusterId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClusterId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecGrpIncByGroupIdxKey ) {
			ICFSecSecGrpIncByGroupIdxKey rhs = (ICFSecSecGrpIncByGroupIdxKey)obj;

			if (getRequiredSecGroupId() != null) {
				if (rhs.getRequiredSecGroupId() != null) {
					cmp = getRequiredSecGroupId().compareTo( rhs.getRequiredSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGroupId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecGrpIncByIncludeIdxKey ) {
			ICFSecSecGrpIncByIncludeIdxKey rhs = (ICFSecSecGrpIncByIncludeIdxKey)obj;

			if (getRequiredIncludeGroupId() != null) {
				if (rhs.getRequiredIncludeGroupId() != null) {
					cmp = getRequiredIncludeGroupId().compareTo( rhs.getRequiredIncludeGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeGroupId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecGrpIncByUIncludeIdxKey ) {
			ICFSecSecGrpIncByUIncludeIdxKey rhs = (ICFSecSecGrpIncByUIncludeIdxKey)obj;

			if (getRequiredClusterId() != null) {
				if (rhs.getRequiredClusterId() != null) {
					cmp = getRequiredClusterId().compareTo( rhs.getRequiredClusterId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClusterId() != null) {
				return( -1 );
			}
			if (getRequiredSecGroupId() != null) {
				if (rhs.getRequiredSecGroupId() != null) {
					cmp = getRequiredSecGroupId().compareTo( rhs.getRequiredSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecGroupId() != null) {
				return( -1 );
			}
			if (getRequiredIncludeGroupId() != null) {
				if (rhs.getRequiredIncludeGroupId() != null) {
					cmp = getRequiredIncludeGroupId().compareTo( rhs.getRequiredIncludeGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeGroupId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFSecSecGrpInc src ) {
		setSecGrpInc( src );
	}

	@Override
	public void setSecGrpInc( ICFSecSecGrpInc src ) {
		setRequiredSecGrpIncId(src.getRequiredSecGrpIncId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredOwnerCluster(src.getRequiredOwnerCluster());
		setRequiredContainerGroup(src.getRequiredContainerGroup());
		setRequiredParentSubGroup(src.getRequiredParentSubGroup());
	}

	@Override
	public void set( ICFSecSecGrpIncH src ) {
		setSecGrpInc( src );
	}

	@Override
	public void setSecGrpInc( ICFSecSecGrpIncH src ) {
		setRequiredSecGrpIncId(src.getRequiredSecGrpIncId());
		setRequiredOwnerCluster(src.getRequiredClusterId());
		setRequiredContainerGroup(src.getRequiredSecGroupId());
		setRequiredParentSubGroup(src.getRequiredIncludeGroupId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredSecGrpIncId=" + "\"" + getRequiredSecGrpIncId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredSecGrpIncId=" + "\"" + getRequiredSecGrpIncId().toString() + "\""
			+ " RequiredClusterId=" + "\"" + getRequiredClusterId().toString() + "\""
			+ " RequiredSecGroupId=" + "\"" + getRequiredSecGroupId().toString() + "\""
			+ " RequiredIncludeGroupId=" + "\"" + getRequiredIncludeGroupId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffSecGrpInc" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
