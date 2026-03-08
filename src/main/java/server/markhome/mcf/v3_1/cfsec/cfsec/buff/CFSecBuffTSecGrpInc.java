// Description: Java 25 implementation of a TSecGrpInc buffer

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

public class CFSecBuffTSecGrpInc
	implements ICFSecTSecGrpInc, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredTSecGrpIncId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecTSecGrpInc.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecTSecGrpInc.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 requiredTenantId;
	protected CFLibDbKeyHash256 requiredTSecGroupId;
	protected CFLibDbKeyHash256 requiredIncludeGroupId;

	public CFSecBuffTSecGrpInc() {
		requiredTSecGrpIncId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpInc.TSECGRPINCID_INIT_VALUE.toString() );
		requiredTenantId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpInc.TENANTID_INIT_VALUE.toString() );
		requiredTSecGroupId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpInc.TSECGROUPID_INIT_VALUE.toString() );
		requiredIncludeGroupId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpInc.INCLUDEGROUPID_INIT_VALUE.toString() );
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredTSecGrpIncId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredTSecGrpIncId) {
		if (requiredTSecGrpIncId != null) {
			setRequiredTSecGrpIncId(requiredTSecGrpIncId);
		}
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTSecGrpIncId() {
		return( requiredTSecGrpIncId );
	}

	@Override
	public void setRequiredTSecGrpIncId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredTSecGrpIncId",
				1,
				"value" );
		}
		requiredTSecGrpIncId = value;
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
		return( ICFSecTSecGrpInc.CLASS_CODE );
	}

	@Override
	public ICFSecTenant getRequiredOwnerTenant() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTenantTable targetTable = targetBackingSchema.getTableTenant();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecTenant targetRec = targetTable.readDerived(null, getRequiredTenantId());
		return(targetRec);
	}
	@Override
	public void setRequiredOwnerTenant(ICFSecTenant argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			requiredTenantId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredOwnerTenant(CFLibDbKeyHash256 argTenantId) {
		requiredTenantId = argTenantId;
	}

	@Override
	public ICFSecTSecGroup getRequiredContainerGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTSecGroupTable targetTable = targetBackingSchema.getTableTSecGroup();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerGroup", 0, "ICFSecSchema.getBackingCFSec().getTableTSecGroup()");
		}
		ICFSecTSecGroup targetRec = targetTable.readDerived(null, getRequiredTSecGroupId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerGroup(ICFSecTSecGroup argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerGroup", 1, "argObj");
		}
		else {
			requiredTSecGroupId = argObj.getRequiredTSecGroupId();
		}
	}

	@Override
	public void setRequiredContainerGroup(CFLibDbKeyHash256 argTSecGroupId) {
		requiredTSecGroupId = argTSecGroupId;
	}

	@Override
	public ICFSecTSecGroup getRequiredParentSubGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentSubGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTSecGroupTable targetTable = targetBackingSchema.getTableTSecGroup();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentSubGroup", 0, "ICFSecSchema.getBackingCFSec().getTableTSecGroup()");
		}
		ICFSecTSecGroup targetRec = targetTable.readDerived(null, getRequiredIncludeGroupId());
		return(targetRec);
	}
	@Override
	public void setRequiredParentSubGroup(ICFSecTSecGroup argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setParentSubGroup", 1, "argObj");
		}
		else {
			requiredIncludeGroupId = argObj.getRequiredTSecGroupId();
		}
	}

	@Override
	public void setRequiredParentSubGroup(CFLibDbKeyHash256 argIncludeGroupId) {
		requiredIncludeGroupId = argIncludeGroupId;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTenantId() {
		return( requiredTenantId );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTSecGroupId() {
		return( requiredTSecGroupId );
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
		else if( obj instanceof ICFSecTSecGrpInc ) {
			ICFSecTSecGrpInc rhs = (ICFSecTSecGrpInc)obj;
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
			if( getRequiredTSecGrpIncId() != null ) {
				if( rhs.getRequiredTSecGrpIncId() != null ) {
					if( ! getRequiredTSecGrpIncId().equals( rhs.getRequiredTSecGrpIncId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGrpIncId() != null ) {
					return( false );
				}
			}
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
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
		else if( obj instanceof ICFSecTSecGrpIncH ) {
			ICFSecTSecGrpIncH rhs = (ICFSecTSecGrpIncH)obj;
			if( getRequiredTSecGrpIncId() != null ) {
				if( rhs.getRequiredTSecGrpIncId() != null ) {
					if( ! getRequiredTSecGrpIncId().equals( rhs.getRequiredTSecGrpIncId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGrpIncId() != null ) {
					return( false );
				}
			}
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
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
		else if( obj instanceof ICFSecTSecGrpIncHPKey ) {
			ICFSecTSecGrpIncHPKey rhs = (ICFSecTSecGrpIncHPKey)obj;
			if( getRequiredTSecGrpIncId() != null ) {
				if( rhs.getRequiredTSecGrpIncId() != null ) {
					if( ! getRequiredTSecGrpIncId().equals( rhs.getRequiredTSecGrpIncId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGrpIncId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpIncByTenantIdxKey ) {
			ICFSecTSecGrpIncByTenantIdxKey rhs = (ICFSecTSecGrpIncByTenantIdxKey)obj;
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpIncByGroupIdxKey ) {
			ICFSecTSecGrpIncByGroupIdxKey rhs = (ICFSecTSecGrpIncByGroupIdxKey)obj;
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpIncByIncludeIdxKey ) {
			ICFSecTSecGrpIncByIncludeIdxKey rhs = (ICFSecTSecGrpIncByIncludeIdxKey)obj;
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
		else if( obj instanceof ICFSecTSecGrpIncByUIncludeIdxKey ) {
			ICFSecTSecGrpIncByUIncludeIdxKey rhs = (ICFSecTSecGrpIncByUIncludeIdxKey)obj;
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
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
		hashCode = hashCode + getRequiredTSecGrpIncId().hashCode();
		hashCode = hashCode + getRequiredTenantId().hashCode();
		hashCode = hashCode + getRequiredTSecGroupId().hashCode();
		hashCode = hashCode + getRequiredIncludeGroupId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecTSecGrpInc ) {
			ICFSecTSecGrpInc rhs = (ICFSecTSecGrpInc)obj;
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
			if (getRequiredTSecGrpIncId() != null) {
				if (rhs.getRequiredTSecGrpIncId() != null) {
					cmp = getRequiredTSecGrpIncId().compareTo( rhs.getRequiredTSecGrpIncId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGrpIncId() != null) {
				return( -1 );
			}
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
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
		else if( obj instanceof ICFSecTSecGrpIncHPKey ) {
			ICFSecTSecGrpIncHPKey rhs = (ICFSecTSecGrpIncHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredTSecGrpIncId() != null) {
				if (rhs.getRequiredTSecGrpIncId() != null) {
					cmp = getRequiredTSecGrpIncId().compareTo( rhs.getRequiredTSecGrpIncId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGrpIncId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpIncH ) {
			ICFSecTSecGrpIncH rhs = (ICFSecTSecGrpIncH)obj;
			cmp = 0;
			if (getRequiredTSecGrpIncId() != null) {
				if (rhs.getRequiredTSecGrpIncId() != null) {
					cmp = getRequiredTSecGrpIncId().compareTo( rhs.getRequiredTSecGrpIncId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGrpIncId() != null) {
				return( -1 );
			}
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
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
		else if( obj instanceof ICFSecTSecGrpIncByTenantIdxKey ) {
			ICFSecTSecGrpIncByTenantIdxKey rhs = (ICFSecTSecGrpIncByTenantIdxKey)obj;

			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpIncByGroupIdxKey ) {
			ICFSecTSecGrpIncByGroupIdxKey rhs = (ICFSecTSecGrpIncByGroupIdxKey)obj;

			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpIncByIncludeIdxKey ) {
			ICFSecTSecGrpIncByIncludeIdxKey rhs = (ICFSecTSecGrpIncByIncludeIdxKey)obj;

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
		else if( obj instanceof ICFSecTSecGrpIncByUIncludeIdxKey ) {
			ICFSecTSecGrpIncByUIncludeIdxKey rhs = (ICFSecTSecGrpIncByUIncludeIdxKey)obj;

			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
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
	public void set( ICFSecTSecGrpInc src ) {
		setTSecGrpInc( src );
	}

	@Override
	public void setTSecGrpInc( ICFSecTSecGrpInc src ) {
		setRequiredTSecGrpIncId(src.getRequiredTSecGrpIncId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setRequiredContainerGroup(src.getRequiredContainerGroup());
		setRequiredParentSubGroup(src.getRequiredParentSubGroup());
	}

	@Override
	public void set( ICFSecTSecGrpIncH src ) {
		setTSecGrpInc( src );
	}

	@Override
	public void setTSecGrpInc( ICFSecTSecGrpIncH src ) {
		setRequiredTSecGrpIncId(src.getRequiredTSecGrpIncId());
		setRequiredOwnerTenant(src.getRequiredTenantId());
		setRequiredContainerGroup(src.getRequiredTSecGroupId());
		setRequiredParentSubGroup(src.getRequiredIncludeGroupId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredTSecGrpIncId=" + "\"" + getRequiredTSecGrpIncId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredTSecGrpIncId=" + "\"" + getRequiredTSecGrpIncId().toString() + "\""
			+ " RequiredTenantId=" + "\"" + getRequiredTenantId().toString() + "\""
			+ " RequiredTSecGroupId=" + "\"" + getRequiredTSecGroupId().toString() + "\""
			+ " RequiredIncludeGroupId=" + "\"" + getRequiredIncludeGroupId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffTSecGrpInc" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
