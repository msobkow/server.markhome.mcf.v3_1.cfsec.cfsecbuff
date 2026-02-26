// Description: Java 25 implementation of a SecUser buffer

/*
 *	io.github.msobkow.CFSec
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

package io.github.msobkow.v3_1.cfsec.cfsec.buff;

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
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
import io.github.msobkow.v3_1.cfsec.cfsec.*;

public class CFSecBuffSecUser
	implements ICFSecSecUser, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredSecUserId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUser.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUser.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredLoginId;
	protected String requiredEMailAddress;
	protected CFLibUuid6 optionalEMailConfirmUuid6;
	protected CFLibDbKeyHash256 optionalDfltDevUserId;
	protected String optionalDfltDevName;
	protected String requiredPasswordHash;
	protected CFLibUuid6 optionalPasswordResetUuid6;

	public CFSecBuffSecUser() {
		requiredSecUserId = CFLibDbKeyHash256.fromHex( ICFSecSecUser.SECUSERID_INIT_VALUE.toString() );
		requiredLoginId = ICFSecSecUser.LOGINID_INIT_VALUE;
		requiredEMailAddress = ICFSecSecUser.EMAILADDRESS_INIT_VALUE;
		optionalEMailConfirmUuid6 = null;
		optionalDfltDevUserId = CFLibDbKeyHash256.nullGet();
		optionalDfltDevName = null;
		optionalPasswordResetUuid6 = null;
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredSecUserId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredSecUserId) {
		if (requiredSecUserId != null) {
			setRequiredSecUserId(requiredSecUserId);
		}
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecUserId() {
		return( requiredSecUserId );
	}

	@Override
	public void setRequiredSecUserId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecUserId",
				1,
				"value" );
		}
		requiredSecUserId = value;
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
		return( ICFSecSecUser.CLASS_CODE );
	}

	@Override
	public List<ICFSecSecDevice> getOptionalComponentsSecDev() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsSecDev", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecDeviceTable targetTable = targetBackingSchema.getTableSecDevice();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsSecDev", 0, "ICFSecSchema.getBackingCFSec().getTableSecDevice()");
		}
		ICFSecSecDevice[] targetArr = targetTable.readDerivedByUserIdx(null, getRequiredSecUserId());
		if( targetArr != null ) {
			List<ICFSecSecDevice> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecSecDevice> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFSecSecGrpMemb> getOptionalChildrenSecGrpMemb() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenSecGrpMemb", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecGrpMembTable targetTable = targetBackingSchema.getTableSecGrpMemb();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenSecGrpMemb", 0, "ICFSecSchema.getBackingCFSec().getTableSecGrpMemb()");
		}
		ICFSecSecGrpMemb[] targetArr = targetTable.readDerivedByUserIdx(null, getRequiredSecUserId());
		if( targetArr != null ) {
			List<ICFSecSecGrpMemb> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecSecGrpMemb> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFSecTSecGrpMemb> getOptionalChildrenTSecGrpMemb() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenTSecGrpMemb", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTSecGrpMembTable targetTable = targetBackingSchema.getTableTSecGrpMemb();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenTSecGrpMemb", 0, "ICFSecSchema.getBackingCFSec().getTableTSecGrpMemb()");
		}
		ICFSecTSecGrpMemb[] targetArr = targetTable.readDerivedByUserIdx(null, getRequiredSecUserId());
		if( targetArr != null ) {
			List<ICFSecTSecGrpMemb> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecTSecGrpMemb> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public ICFSecSecDevice getOptionalLookupDefDev() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalLookupDefDev", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecDeviceTable targetTable = targetBackingSchema.getTableSecDevice();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalLookupDefDev", 0, "ICFSecSchema.getBackingCFSec().getTableSecDevice()");
		}
		ICFSecSecDevice targetRec = targetTable.readDerived(null, getOptionalDfltDevUserId(), getOptionalDfltDevName());
		return(targetRec);
	}
	@Override
	public void setOptionalLookupDefDev(ICFSecSecDevice argObj) {
		if(argObj == null) {
			optionalDfltDevUserId = null;
			optionalDfltDevName = null;
		}
		else {
			optionalDfltDevUserId = argObj.getRequiredSecUserId();
			optionalDfltDevName = argObj.getRequiredDevName();
		}
	}

	@Override
	public void setOptionalLookupDefDev(CFLibDbKeyHash256 argDfltDevUserId,
		String argDfltDevName) {
		optionalDfltDevUserId = argDfltDevUserId;
		optionalDfltDevName = argDfltDevName;
	}

	@Override
	public String getRequiredLoginId() {
		return( requiredLoginId );
	}

	@Override
	public void setRequiredLoginId( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredLoginId",
				1,
				"value" );
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredLoginId",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		requiredLoginId = value;
	}

	@Override
	public String getRequiredEMailAddress() {
		return( requiredEMailAddress );
	}

	@Override
	public void setRequiredEMailAddress( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredEMailAddress",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredEMailAddress",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredEMailAddress = value;
	}

	@Override
	public CFLibUuid6 getOptionalEMailConfirmUuid6() {
		return( optionalEMailConfirmUuid6 );
	}

	@Override
	public void setOptionalEMailConfirmUuid6( CFLibUuid6 value ) {
		optionalEMailConfirmUuid6 = value;
	}

	@Override
	public CFLibDbKeyHash256 getOptionalDfltDevUserId() {
		return( optionalDfltDevUserId );
	}

	@Override
	public String getOptionalDfltDevName() {
		return( optionalDfltDevName );
	}

	@Override
	public String getRequiredPasswordHash() {
		return( requiredPasswordHash );
	}

	@Override
	public void setRequiredPasswordHash( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredPasswordHash",
				1,
				"value" );
		}
		else if( value.length() > 256 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredPasswordHash",
				1,
				"value.length()",
				value.length(),
				256 );
		}
		requiredPasswordHash = value;
	}

	@Override
	public CFLibUuid6 getOptionalPasswordResetUuid6() {
		return( optionalPasswordResetUuid6 );
	}

	@Override
	public void setOptionalPasswordResetUuid6( CFLibUuid6 value ) {
		optionalPasswordResetUuid6 = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecSecUser ) {
			ICFSecSecUser rhs = (ICFSecSecUser)obj;
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
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			if( getRequiredLoginId() != null ) {
				if( rhs.getRequiredLoginId() != null ) {
					if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoginId() != null ) {
					return( false );
				}
			}
			if( getRequiredEMailAddress() != null ) {
				if( rhs.getRequiredEMailAddress() != null ) {
					if( ! getRequiredEMailAddress().equals( rhs.getRequiredEMailAddress() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailAddress() != null ) {
					return( false );
				}
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					if( ! getOptionalEMailConfirmUuid6().equals( rhs.getOptionalEMailConfirmUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltDevUserId() != null ) {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					if( ! getOptionalDfltDevUserId().equals( rhs.getOptionalDfltDevUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltDevName() != null ) {
				if( rhs.getOptionalDfltDevName() != null ) {
					if( ! getOptionalDfltDevName().equals( rhs.getOptionalDfltDevName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltDevName() != null ) {
					return( false );
				}
			}
			if( getRequiredPasswordHash() != null ) {
				if( rhs.getRequiredPasswordHash() != null ) {
					if( ! getRequiredPasswordHash().equals( rhs.getRequiredPasswordHash() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPasswordHash() != null ) {
					return( false );
				}
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					if( ! getOptionalPasswordResetUuid6().equals( rhs.getOptionalPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserH ) {
			ICFSecSecUserH rhs = (ICFSecSecUserH)obj;
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			if( getRequiredLoginId() != null ) {
				if( rhs.getRequiredLoginId() != null ) {
					if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoginId() != null ) {
					return( false );
				}
			}
			if( getRequiredEMailAddress() != null ) {
				if( rhs.getRequiredEMailAddress() != null ) {
					if( ! getRequiredEMailAddress().equals( rhs.getRequiredEMailAddress() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailAddress() != null ) {
					return( false );
				}
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					if( ! getOptionalEMailConfirmUuid6().equals( rhs.getOptionalEMailConfirmUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltDevUserId() != null ) {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					if( ! getOptionalDfltDevUserId().equals( rhs.getOptionalDfltDevUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltDevName() != null ) {
				if( rhs.getOptionalDfltDevName() != null ) {
					if( ! getOptionalDfltDevName().equals( rhs.getOptionalDfltDevName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltDevName() != null ) {
					return( false );
				}
			}
			if( getRequiredPasswordHash() != null ) {
				if( rhs.getRequiredPasswordHash() != null ) {
					if( ! getRequiredPasswordHash().equals( rhs.getRequiredPasswordHash() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPasswordHash() != null ) {
					return( false );
				}
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					if( ! getOptionalPasswordResetUuid6().equals( rhs.getOptionalPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserHPKey ) {
			ICFSecSecUserHPKey rhs = (ICFSecSecUserHPKey)obj;
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserByULoginIdxKey ) {
			ICFSecSecUserByULoginIdxKey rhs = (ICFSecSecUserByULoginIdxKey)obj;
			if( getRequiredLoginId() != null ) {
				if( rhs.getRequiredLoginId() != null ) {
					if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoginId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserByEMConfIdxKey ) {
			ICFSecSecUserByEMConfIdxKey rhs = (ICFSecSecUserByEMConfIdxKey)obj;
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					if( ! getOptionalEMailConfirmUuid6().equals( rhs.getOptionalEMailConfirmUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserByPwdResetIdxKey ) {
			ICFSecSecUserByPwdResetIdxKey rhs = (ICFSecSecUserByPwdResetIdxKey)obj;
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					if( ! getOptionalPasswordResetUuid6().equals( rhs.getOptionalPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserByDefDevIdxKey ) {
			ICFSecSecUserByDefDevIdxKey rhs = (ICFSecSecUserByDefDevIdxKey)obj;
			if( getOptionalDfltDevUserId() != null ) {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					if( ! getOptionalDfltDevUserId().equals( rhs.getOptionalDfltDevUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltDevName() != null ) {
				if( rhs.getOptionalDfltDevName() != null ) {
					if( ! getOptionalDfltDevName().equals( rhs.getOptionalDfltDevName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltDevName() != null ) {
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
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		if( getRequiredLoginId() != null ) {
			hashCode = hashCode + getRequiredLoginId().hashCode();
		}
		if( getRequiredEMailAddress() != null ) {
			hashCode = hashCode + getRequiredEMailAddress().hashCode();
		}
		if( getOptionalEMailConfirmUuid6() != null ) {
			hashCode = hashCode + getOptionalEMailConfirmUuid6().hashCode();
		}
		if( getOptionalDfltDevUserId() != null ) {
			hashCode = hashCode + getOptionalDfltDevUserId().hashCode();
		}
		if( getOptionalDfltDevName() != null ) {
			hashCode = hashCode + getOptionalDfltDevName().hashCode();
		}
		if( getRequiredPasswordHash() != null ) {
			hashCode = hashCode + getRequiredPasswordHash().hashCode();
		}
		if( getOptionalPasswordResetUuid6() != null ) {
			hashCode = hashCode + getOptionalPasswordResetUuid6().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecSecUser ) {
			ICFSecSecUser rhs = (ICFSecSecUser)obj;
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
			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}
			if (getRequiredLoginId() != null) {
				if (rhs.getRequiredLoginId() != null) {
					cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoginId() != null) {
				return( -1 );
			}
			if (getRequiredEMailAddress() != null) {
				if (rhs.getRequiredEMailAddress() != null) {
					cmp = getRequiredEMailAddress().compareTo( rhs.getRequiredEMailAddress() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailAddress() != null) {
				return( -1 );
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					cmp = getOptionalEMailConfirmUuid6().compareTo( rhs.getOptionalEMailConfirmUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltDevUserId() != null ) {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					cmp = getOptionalDfltDevUserId().compareTo( rhs.getOptionalDfltDevUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltDevName() != null ) {
				if( rhs.getOptionalDfltDevName() != null ) {
					cmp = getOptionalDfltDevName().compareTo( rhs.getOptionalDfltDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltDevName() != null ) {
					return( -1 );
				}
			}
			if (getRequiredPasswordHash() != null) {
				if (rhs.getRequiredPasswordHash() != null) {
					cmp = getRequiredPasswordHash().compareTo( rhs.getRequiredPasswordHash() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPasswordHash() != null) {
				return( -1 );
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					cmp = getOptionalPasswordResetUuid6().compareTo( rhs.getOptionalPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserHPKey ) {
			ICFSecSecUserHPKey rhs = (ICFSecSecUserHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserH ) {
			ICFSecSecUserH rhs = (ICFSecSecUserH)obj;
			cmp = 0;
			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}
			if (getRequiredLoginId() != null) {
				if (rhs.getRequiredLoginId() != null) {
					cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoginId() != null) {
				return( -1 );
			}
			if (getRequiredEMailAddress() != null) {
				if (rhs.getRequiredEMailAddress() != null) {
					cmp = getRequiredEMailAddress().compareTo( rhs.getRequiredEMailAddress() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailAddress() != null) {
				return( -1 );
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					cmp = getOptionalEMailConfirmUuid6().compareTo( rhs.getOptionalEMailConfirmUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltDevUserId() != null ) {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					cmp = getOptionalDfltDevUserId().compareTo( rhs.getOptionalDfltDevUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltDevName() != null ) {
				if( rhs.getOptionalDfltDevName() != null ) {
					cmp = getOptionalDfltDevName().compareTo( rhs.getOptionalDfltDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltDevName() != null ) {
					return( -1 );
				}
			}
			if (getRequiredPasswordHash() != null) {
				if (rhs.getRequiredPasswordHash() != null) {
					cmp = getRequiredPasswordHash().compareTo( rhs.getRequiredPasswordHash() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPasswordHash() != null) {
				return( -1 );
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					cmp = getOptionalPasswordResetUuid6().compareTo( rhs.getOptionalPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserByULoginIdxKey ) {
			ICFSecSecUserByULoginIdxKey rhs = (ICFSecSecUserByULoginIdxKey)obj;

			if (getRequiredLoginId() != null) {
				if (rhs.getRequiredLoginId() != null) {
					cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoginId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserByEMConfIdxKey ) {
			ICFSecSecUserByEMConfIdxKey rhs = (ICFSecSecUserByEMConfIdxKey)obj;

			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					cmp = getOptionalEMailConfirmUuid6().compareTo( rhs.getOptionalEMailConfirmUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserByPwdResetIdxKey ) {
			ICFSecSecUserByPwdResetIdxKey rhs = (ICFSecSecUserByPwdResetIdxKey)obj;

			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					cmp = getOptionalPasswordResetUuid6().compareTo( rhs.getOptionalPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserByDefDevIdxKey ) {
			ICFSecSecUserByDefDevIdxKey rhs = (ICFSecSecUserByDefDevIdxKey)obj;

			if( getOptionalDfltDevUserId() != null ) {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					cmp = getOptionalDfltDevUserId().compareTo( rhs.getOptionalDfltDevUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltDevUserId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltDevName() != null ) {
				if( rhs.getOptionalDfltDevName() != null ) {
					cmp = getOptionalDfltDevName().compareTo( rhs.getOptionalDfltDevName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltDevName() != null ) {
					return( -1 );
				}
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
	public void set( ICFSecSecUser src ) {
		setSecUser( src );
	}

	@Override
	public void setSecUser( ICFSecSecUser src ) {
		setRequiredSecUserId(src.getRequiredSecUserId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setOptionalLookupDefDev(src.getOptionalLookupDefDev());
		setRequiredLoginId(src.getRequiredLoginId());
		setRequiredEMailAddress(src.getRequiredEMailAddress());
		setOptionalEMailConfirmUuid6(src.getOptionalEMailConfirmUuid6());
		setRequiredPasswordHash(src.getRequiredPasswordHash());
		setOptionalPasswordResetUuid6(src.getOptionalPasswordResetUuid6());
	}

	@Override
	public void set( ICFSecSecUserH src ) {
		setSecUser( src );
	}

	@Override
	public void setSecUser( ICFSecSecUserH src ) {
		setRequiredSecUserId(src.getRequiredSecUserId());
		setOptionalLookupDefDev(src.getOptionalDfltDevUserId(),
			src.getOptionalDfltDevName());
		setRequiredLoginId(src.getRequiredLoginId());
		setRequiredEMailAddress(src.getRequiredEMailAddress());
		setOptionalEMailConfirmUuid6(src.getOptionalEMailConfirmUuid6());
		setRequiredPasswordHash(src.getRequiredPasswordHash());
		setOptionalPasswordResetUuid6(src.getOptionalPasswordResetUuid6());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ " RequiredLoginId=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredLoginId() ) + "\""
			+ " RequiredEMailAddress=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEMailAddress() ) + "\""
			+ " OptionalEMailConfirmUuid6=" + ( ( getOptionalEMailConfirmUuid6() == null ) ? "null" : "\"" + getOptionalEMailConfirmUuid6().toString() + "\"" )
			+ " OptionalDfltDevUserId=" + ( ( getOptionalDfltDevUserId() == null ) ? "null" : "\"" + getOptionalDfltDevUserId().toString() + "\"" )
			+ " OptionalDfltDevName=" + ( ( getOptionalDfltDevName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDfltDevName() ) + "\"" )
			+ " RequiredPasswordHash=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredPasswordHash() ) + "\""
			+ " OptionalPasswordResetUuid6=" + ( ( getOptionalPasswordResetUuid6() == null ) ? "null" : "\"" + getOptionalPasswordResetUuid6().toString() + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffSecUser" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
