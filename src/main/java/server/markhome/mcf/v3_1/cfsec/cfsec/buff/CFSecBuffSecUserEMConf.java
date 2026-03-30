// Description: Java 25 implementation of a SecUserEMConf buffer

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

public class CFSecBuffSecUserEMConf
	implements ICFSecSecUserEMConf, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredSecUserId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUserEMConf.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUserEMConf.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredConfirmEMailAddr;
	protected LocalDateTime requiredEMailSentStamp;
	protected CFLibUuid6 requiredEMConfirmationUuid6;
	protected boolean requiredNewAccount;

	public CFSecBuffSecUserEMConf() {
		requiredSecUserId = CFLibDbKeyHash256.fromHex( ICFSecSecUserEMConf.SECUSERID_INIT_VALUE.toString() );
		requiredConfirmEMailAddr = ICFSecSecUserEMConf.CONFIRMEMAILADDR_INIT_VALUE;
		requiredEMailSentStamp = CFLibXmlUtil.parseTimestamp("2020-01-01T00:00:00");
		requiredNewAccount = ICFSecSecUserEMConf.NEWACCOUNT_INIT_VALUE;
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredSecUserId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredSecUserId) {
		this.requiredSecUserId = requiredSecUserId;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecUserId() {
		return( requiredSecUserId );
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
		return( ICFSecSecUserEMConf.CLASS_CODE );
	}

	@Override
	public ICFSecSecUser getRequiredContainerUser() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerUser", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecUserTable targetTable = targetBackingSchema.getTableSecUser();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerUser", 0, "ICFSecSchema.getBackingCFSec().getTableSecUser()");
		}
		ICFSecSecUser targetRec = targetTable.readDerived(null, getRequiredSecUserId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerUser(ICFSecSecUser argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerUser", 1, "argObj");
		}
		else {
			requiredSecUserId = argObj.getRequiredSecUserId();
		}
	
	}

	@Override
	public void setRequiredContainerUser(CFLibDbKeyHash256 argSecUserId) {
		requiredSecUserId = argSecUserId;
	}
	@Override
	public String getRequiredConfirmEMailAddr() {
		return( requiredConfirmEMailAddr );
	}

	@Override
	public void setRequiredConfirmEMailAddr( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredConfirmEMailAddr",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredConfirmEMailAddr",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredConfirmEMailAddr = value;
	}

	@Override
	public LocalDateTime getRequiredEMailSentStamp() {
		return( requiredEMailSentStamp );
	}

	@Override
	public void setRequiredEMailSentStamp( LocalDateTime value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredEMailSentStamp",
				1,
				"value" );
		}
		requiredEMailSentStamp = value;
	}

	@Override
	public CFLibUuid6 getRequiredEMConfirmationUuid6() {
		return( requiredEMConfirmationUuid6 );
	}

	@Override
	public void setRequiredEMConfirmationUuid6( CFLibUuid6 value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredEMConfirmationUuid6",
				1,
				"value" );
		}
		requiredEMConfirmationUuid6 = value;
	}

	@Override
	public boolean getRequiredNewAccount() {
		return( requiredNewAccount );
	}

	@Override
	public void setRequiredNewAccount( boolean value ) {
		requiredNewAccount = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecSecUserEMConf ) {
			ICFSecSecUserEMConf rhs = (ICFSecSecUserEMConf)obj;
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
			if( getRequiredConfirmEMailAddr() != null ) {
				if( rhs.getRequiredConfirmEMailAddr() != null ) {
					if( ! getRequiredConfirmEMailAddr().equals( rhs.getRequiredConfirmEMailAddr() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredConfirmEMailAddr() != null ) {
					return( false );
				}
			}
			if( getRequiredEMailSentStamp() != null ) {
				if( rhs.getRequiredEMailSentStamp() != null ) {
					if( ! getRequiredEMailSentStamp().equals( rhs.getRequiredEMailSentStamp() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailSentStamp() != null ) {
					return( false );
				}
			}
			if( getRequiredEMConfirmationUuid6() != null ) {
				if( rhs.getRequiredEMConfirmationUuid6() != null ) {
					if( ! getRequiredEMConfirmationUuid6().equals( rhs.getRequiredEMConfirmationUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMConfirmationUuid6() != null ) {
					return( false );
				}
			}
			if( getRequiredNewAccount() != rhs.getRequiredNewAccount() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserEMConfH ) {
			ICFSecSecUserEMConfH rhs = (ICFSecSecUserEMConfH)obj;
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
			if( getRequiredConfirmEMailAddr() != null ) {
				if( rhs.getRequiredConfirmEMailAddr() != null ) {
					if( ! getRequiredConfirmEMailAddr().equals( rhs.getRequiredConfirmEMailAddr() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredConfirmEMailAddr() != null ) {
					return( false );
				}
			}
			if( getRequiredEMailSentStamp() != null ) {
				if( rhs.getRequiredEMailSentStamp() != null ) {
					if( ! getRequiredEMailSentStamp().equals( rhs.getRequiredEMailSentStamp() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailSentStamp() != null ) {
					return( false );
				}
			}
			if( getRequiredEMConfirmationUuid6() != null ) {
				if( rhs.getRequiredEMConfirmationUuid6() != null ) {
					if( ! getRequiredEMConfirmationUuid6().equals( rhs.getRequiredEMConfirmationUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMConfirmationUuid6() != null ) {
					return( false );
				}
			}
			if( getRequiredNewAccount() != rhs.getRequiredNewAccount() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserEMConfHPKey ) {
			ICFSecSecUserEMConfHPKey rhs = (ICFSecSecUserEMConfHPKey)obj;
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
		else if( obj instanceof ICFSecSecUserEMConfByUUuid6IdxKey ) {
			ICFSecSecUserEMConfByUUuid6IdxKey rhs = (ICFSecSecUserEMConfByUUuid6IdxKey)obj;
			if( getRequiredEMConfirmationUuid6() != null ) {
				if( rhs.getRequiredEMConfirmationUuid6() != null ) {
					if( ! getRequiredEMConfirmationUuid6().equals( rhs.getRequiredEMConfirmationUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMConfirmationUuid6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserEMConfByConfEMAddrIdxKey ) {
			ICFSecSecUserEMConfByConfEMAddrIdxKey rhs = (ICFSecSecUserEMConfByConfEMAddrIdxKey)obj;
			if( getRequiredConfirmEMailAddr() != null ) {
				if( rhs.getRequiredConfirmEMailAddr() != null ) {
					if( ! getRequiredConfirmEMailAddr().equals( rhs.getRequiredConfirmEMailAddr() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredConfirmEMailAddr() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserEMConfBySentStampIdxKey ) {
			ICFSecSecUserEMConfBySentStampIdxKey rhs = (ICFSecSecUserEMConfBySentStampIdxKey)obj;
			if( getRequiredEMailSentStamp() != null ) {
				if( rhs.getRequiredEMailSentStamp() != null ) {
					if( ! getRequiredEMailSentStamp().equals( rhs.getRequiredEMailSentStamp() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailSentStamp() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecUserEMConfByNewAcctIdxKey ) {
			ICFSecSecUserEMConfByNewAcctIdxKey rhs = (ICFSecSecUserEMConfByNewAcctIdxKey)obj;
			if( getRequiredNewAccount() != rhs.getRequiredNewAccount() ) {
				return( false );
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
		if( getRequiredConfirmEMailAddr() != null ) {
			hashCode = hashCode + getRequiredConfirmEMailAddr().hashCode();
		}
		if( getRequiredEMailSentStamp() != null ) {
			hashCode = hashCode + getRequiredEMailSentStamp().hashCode();
		}
		hashCode = hashCode + getRequiredEMConfirmationUuid6().hashCode();
		if( getRequiredNewAccount() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecSecUserEMConf ) {
			ICFSecSecUserEMConf rhs = (ICFSecSecUserEMConf)obj;
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
			if (getRequiredConfirmEMailAddr() != null) {
				if (rhs.getRequiredConfirmEMailAddr() != null) {
					cmp = getRequiredConfirmEMailAddr().compareTo( rhs.getRequiredConfirmEMailAddr() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredConfirmEMailAddr() != null) {
				return( -1 );
			}
			if (getRequiredEMailSentStamp() != null) {
				if (rhs.getRequiredEMailSentStamp() != null) {
					cmp = getRequiredEMailSentStamp().compareTo( rhs.getRequiredEMailSentStamp() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailSentStamp() != null) {
				return( -1 );
			}
			if (getRequiredEMConfirmationUuid6() != null) {
				if (rhs.getRequiredEMConfirmationUuid6() != null) {
					cmp = getRequiredEMConfirmationUuid6().compareTo( rhs.getRequiredEMConfirmationUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMConfirmationUuid6() != null) {
				return( -1 );
			}
			if( getRequiredNewAccount() ) {
				if( ! rhs.getRequiredNewAccount() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredNewAccount() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserEMConfHPKey ) {
			ICFSecSecUserEMConfHPKey rhs = (ICFSecSecUserEMConfHPKey)obj;
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
		else if( obj instanceof ICFSecSecUserEMConfH ) {
			ICFSecSecUserEMConfH rhs = (ICFSecSecUserEMConfH)obj;
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
			if (getRequiredConfirmEMailAddr() != null) {
				if (rhs.getRequiredConfirmEMailAddr() != null) {
					cmp = getRequiredConfirmEMailAddr().compareTo( rhs.getRequiredConfirmEMailAddr() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredConfirmEMailAddr() != null) {
				return( -1 );
			}
			if (getRequiredEMailSentStamp() != null) {
				if (rhs.getRequiredEMailSentStamp() != null) {
					cmp = getRequiredEMailSentStamp().compareTo( rhs.getRequiredEMailSentStamp() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailSentStamp() != null) {
				return( -1 );
			}
			if (getRequiredEMConfirmationUuid6() != null) {
				if (rhs.getRequiredEMConfirmationUuid6() != null) {
					cmp = getRequiredEMConfirmationUuid6().compareTo( rhs.getRequiredEMConfirmationUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMConfirmationUuid6() != null) {
				return( -1 );
			}
			if( getRequiredNewAccount() ) {
				if( ! rhs.getRequiredNewAccount() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredNewAccount() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserEMConfByUUuid6IdxKey ) {
			ICFSecSecUserEMConfByUUuid6IdxKey rhs = (ICFSecSecUserEMConfByUUuid6IdxKey)obj;

			if (getRequiredEMConfirmationUuid6() != null) {
				if (rhs.getRequiredEMConfirmationUuid6() != null) {
					cmp = getRequiredEMConfirmationUuid6().compareTo( rhs.getRequiredEMConfirmationUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMConfirmationUuid6() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserEMConfByConfEMAddrIdxKey ) {
			ICFSecSecUserEMConfByConfEMAddrIdxKey rhs = (ICFSecSecUserEMConfByConfEMAddrIdxKey)obj;

			if (getRequiredConfirmEMailAddr() != null) {
				if (rhs.getRequiredConfirmEMailAddr() != null) {
					cmp = getRequiredConfirmEMailAddr().compareTo( rhs.getRequiredConfirmEMailAddr() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredConfirmEMailAddr() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserEMConfBySentStampIdxKey ) {
			ICFSecSecUserEMConfBySentStampIdxKey rhs = (ICFSecSecUserEMConfBySentStampIdxKey)obj;

			if (getRequiredEMailSentStamp() != null) {
				if (rhs.getRequiredEMailSentStamp() != null) {
					cmp = getRequiredEMailSentStamp().compareTo( rhs.getRequiredEMailSentStamp() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailSentStamp() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecUserEMConfByNewAcctIdxKey ) {
			ICFSecSecUserEMConfByNewAcctIdxKey rhs = (ICFSecSecUserEMConfByNewAcctIdxKey)obj;

			if( getRequiredNewAccount() ) {
				if( ! rhs.getRequiredNewAccount() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredNewAccount() ) {
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
	public void set( ICFSecSecUserEMConf src ) {
		setSecUserEMConf( src );
	}

	@Override
	public void setSecUserEMConf( ICFSecSecUserEMConf src ) {
		setRequiredContainerUser(src.getRequiredContainerUser());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredConfirmEMailAddr(src.getRequiredConfirmEMailAddr());
		setRequiredEMailSentStamp(src.getRequiredEMailSentStamp());
		setRequiredEMConfirmationUuid6(src.getRequiredEMConfirmationUuid6());
		setRequiredNewAccount(src.getRequiredNewAccount());
	}

	@Override
	public void set( ICFSecSecUserEMConfH src ) {
		setSecUserEMConf( src );
	}

	@Override
	public void setSecUserEMConf( ICFSecSecUserEMConfH src ) {
		setRequiredContainerUser(src.getRequiredSecUserId());
		setRequiredConfirmEMailAddr(src.getRequiredConfirmEMailAddr());
		setRequiredEMailSentStamp(src.getRequiredEMailSentStamp());
		setRequiredEMConfirmationUuid6(src.getRequiredEMConfirmationUuid6());
		setRequiredNewAccount(src.getRequiredNewAccount());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\""
			+ " RequiredConfirmEMailAddr=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredConfirmEMailAddr() ) + "\""
			+ " RequiredEMailSentStamp=" + "\"" + getRequiredEMailSentStamp().toString() + "\""
			+ " RequiredEMConfirmationUuid6=" + "\"" + getRequiredEMConfirmationUuid6().toString() + "\""
			+ " RequiredNewAccount=" + (( getRequiredNewAccount() ) ? "\"true\"" : "\"false\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffSecUserEMConf" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
