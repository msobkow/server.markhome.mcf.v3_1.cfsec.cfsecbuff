// Description: Java 25 implementation of a SecUser history buffer object

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

public class CFSecBuffSecUserH
    implements ICFSecSecUserH, Comparable<Object>, Serializable
{
    protected CFSecBuffSecUserHPKey pkey;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUser.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUser.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredLoginId;
	protected ICFSecSchema.SecAccountStatusEnum requiredAccountStatus;
	protected String optionalDfltSysGrpName;
	protected String optionalDfltClusGrpName;
	protected String optionalDfltTentGrpName;
	protected String requiredEMailAddress;

    public CFSecBuffSecUserH() {
            // The primary key member attributes are initialized on construction
            pkey = new CFSecBuffSecUserHPKey();
		requiredLoginId = ICFSecSecUser.LOGINID_INIT_VALUE;
		requiredAccountStatus = ICFSecSecUser.ACCOUNTSTATUS_INIT_VALUE;
		optionalDfltSysGrpName = null;
		optionalDfltClusGrpName = null;
		optionalDfltTentGrpName = null;
		requiredEMailAddress = ICFSecSecUser.EMAILADDRESS_INIT_VALUE;
    }

    @Override
    public int getClassCode() {
            return( ICFSecSecUser.CLASS_CODE );
    }

    @Override
    public CFLibDbKeyHash256 getCreatedByUserId() {
        return( createdByUserId );
    }

    @Override
    public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
        }
        createdByUserId = value;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return( createdAt );
    }

    @Override
    public void setCreatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedAt", 1, "value");
        }
        createdAt = value;
    }

    @Override
    public CFLibDbKeyHash256 getUpdatedByUserId() {
        return( updatedByUserId );
    }

    @Override
    public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
        }
        updatedByUserId = value;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return( updatedAt );
    }

    @Override
    public void setUpdatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
        }
        updatedAt = value;
    }

    @Override
    public ICFSecSecUserHPKey getPKey() {
        return( pkey );
    }

    @Override
    public void setPKey( ICFSecSecUserHPKey pkey ) {
        if (pkey != null) {
            if (pkey instanceof CFSecBuffSecUserHPKey) {
                this.pkey = (CFSecBuffSecUserHPKey)pkey;
            }
            else {
                throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffSecUserHPKey");
            }
        }
    }

    @Override
    public CFLibDbKeyHash256 getAuditClusterId() {
        return pkey.getAuditClusterId();
    }

    @Override
    public void setAuditClusterId(CFLibDbKeyHash256 auditClusterId) {
        pkey.setAuditClusterId(auditClusterId);
    }

    @Override
    public LocalDateTime getAuditStamp() {
        return pkey.getAuditStamp();
    }

    @Override
    public void setAuditStamp(LocalDateTime auditStamp) {
        pkey.setAuditStamp(auditStamp);
    }

    @Override
    public short getAuditActionId() {
        return pkey.getAuditActionId();
    }

    @Override
    public void setAuditActionId(short auditActionId) {
        pkey.setAuditActionId(auditActionId);
    }

    @Override
    public int getRequiredRevision() {
        return pkey.getRequiredRevision();
    }

    @Override
    public void setRequiredRevision(int revision) {
        pkey.setRequiredRevision(revision);
    }

    @Override
    public CFLibDbKeyHash256 getAuditSessionId() {
        return pkey.getAuditSessionId();
    }

    @Override
    public void setAuditSessionId(CFLibDbKeyHash256 auditSessionId) {
        pkey.setAuditSessionId(auditSessionId);
    }

    @Override
    public CFLibDbKeyHash256 getRequiredSecUserId() {
        return( pkey.getRequiredSecUserId() );
    }

    @Override
    public void setRequiredSecUserId( CFLibDbKeyHash256 requiredSecUserId ) {
        pkey.setRequiredSecUserId( requiredSecUserId );
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
	public ICFSecSchema.SecAccountStatusEnum getRequiredAccountStatus() {
		return( requiredAccountStatus );
	}

	@Override
	public void setRequiredAccountStatus( ICFSecSchema.SecAccountStatusEnum value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredAccountStatus",
				1,
				"value" );
		}
		requiredAccountStatus = value;
	}

	@Override
	public String getOptionalDfltSysGrpName() {
		return( optionalDfltSysGrpName );
	}

	@Override
	public void setOptionalDfltSysGrpName( String value ) {
		if( value != null && value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDfltSysGrpName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		optionalDfltSysGrpName = value;
	}

	@Override
	public String getOptionalDfltClusGrpName() {
		return( optionalDfltClusGrpName );
	}

	@Override
	public void setOptionalDfltClusGrpName( String value ) {
		if( value != null && value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDfltClusGrpName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		optionalDfltClusGrpName = value;
	}

	@Override
	public String getOptionalDfltTentGrpName() {
		return( optionalDfltTentGrpName );
	}

	@Override
	public void setOptionalDfltTentGrpName( String value ) {
		if( value != null && value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDfltTentGrpName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		optionalDfltTentGrpName = value;
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
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof ICFSecSecUser) {
            ICFSecSecUser rhs = (ICFSecSecUser)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
			return( false );
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
			if( getRequiredAccountStatus() != null ) {
				if( rhs.getRequiredAccountStatus() != null ) {
					if( ! getRequiredAccountStatus().equals( rhs.getRequiredAccountStatus() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAccountStatus() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltSysGrpName() != null ) {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					if( ! getOptionalDfltSysGrpName().equals( rhs.getOptionalDfltSysGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltClusGrpName() != null ) {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					if( ! getOptionalDfltClusGrpName().equals( rhs.getOptionalDfltClusGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltTentGrpName() != null ) {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
					if( ! getOptionalDfltTentGrpName().equals( rhs.getOptionalDfltTentGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
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
            return( true );
        }
        else if (obj instanceof ICFSecSecUserH) {
            ICFSecSecUserH rhs = (ICFSecSecUserH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
			return( false );
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
			if( getRequiredAccountStatus() != null ) {
				if( rhs.getRequiredAccountStatus() != null ) {
					if( ! getRequiredAccountStatus().equals( rhs.getRequiredAccountStatus() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAccountStatus() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltSysGrpName() != null ) {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					if( ! getOptionalDfltSysGrpName().equals( rhs.getOptionalDfltSysGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltClusGrpName() != null ) {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					if( ! getOptionalDfltClusGrpName().equals( rhs.getOptionalDfltClusGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					return( false );
				}
			}
			if( getOptionalDfltTentGrpName() != null ) {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
					if( ! getOptionalDfltTentGrpName().equals( rhs.getOptionalDfltTentGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
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
            return( true );
        }
        else if (obj instanceof ICFSecSecUserHPKey) {
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
        else if (obj instanceof ICFSecSecUserByULoginIdxKey) {
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
        else if (obj instanceof ICFSecSecUserByEMAddrIdxKey) {
            ICFSecSecUserByEMAddrIdxKey rhs = (ICFSecSecUserByEMAddrIdxKey)obj;
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
            return( true );
        }
        else {
			return( false );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = pkey.hashCode();
		if( getRequiredLoginId() != null ) {
			hashCode = hashCode + getRequiredLoginId().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredAccountStatus().ordinal();
		if( getOptionalDfltSysGrpName() != null ) {
			hashCode = hashCode + getOptionalDfltSysGrpName().hashCode();
		}
		if( getOptionalDfltClusGrpName() != null ) {
			hashCode = hashCode + getOptionalDfltClusGrpName().hashCode();
		}
		if( getOptionalDfltTentGrpName() != null ) {
			hashCode = hashCode + getOptionalDfltTentGrpName().hashCode();
		}
		if( getRequiredEMailAddress() != null ) {
			hashCode = hashCode + getRequiredEMailAddress().hashCode();
		}
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof ICFSecSecUser) {
		ICFSecSecUser rhs = (ICFSecSecUser)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
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
			if (getRequiredAccountStatus() != null) {
				if (rhs.getRequiredAccountStatus() != null) {
					cmp = getRequiredAccountStatus().compareTo( rhs.getRequiredAccountStatus() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAccountStatus() != null) {
				return( -1 );
			}
			if( getOptionalDfltSysGrpName() != null ) {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					cmp = getOptionalDfltSysGrpName().compareTo( rhs.getOptionalDfltSysGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltClusGrpName() != null ) {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					cmp = getOptionalDfltClusGrpName().compareTo( rhs.getOptionalDfltClusGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltTentGrpName() != null ) {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
					cmp = getOptionalDfltTentGrpName().compareTo( rhs.getOptionalDfltTentGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
					return( -1 );
				}
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
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserHPKey) {
        if (getPKey() != null) {
            return( getPKey().compareTo( obj ));
        }
        else {
            return( -1 );
        }
        }
        else if (obj instanceof ICFSecSecUserH) {
		ICFSecSecUserH rhs = (ICFSecSecUserH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
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
			if (getRequiredAccountStatus() != null) {
				if (rhs.getRequiredAccountStatus() != null) {
					cmp = getRequiredAccountStatus().compareTo( rhs.getRequiredAccountStatus() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAccountStatus() != null) {
				return( -1 );
			}
			if( getOptionalDfltSysGrpName() != null ) {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					cmp = getOptionalDfltSysGrpName().compareTo( rhs.getOptionalDfltSysGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltSysGrpName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltClusGrpName() != null ) {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					cmp = getOptionalDfltClusGrpName().compareTo( rhs.getOptionalDfltClusGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltClusGrpName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDfltTentGrpName() != null ) {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
					cmp = getOptionalDfltTentGrpName().compareTo( rhs.getOptionalDfltTentGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDfltTentGrpName() != null ) {
					return( -1 );
				}
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
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserByULoginIdxKey ) {
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
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserByEMAddrIdxKey ) {
            ICFSecSecUserByEMAddrIdxKey rhs = (ICFSecSecUserByEMAddrIdxKey)obj;
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
            return( 0 );
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
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setRequiredLoginId( src.getRequiredLoginId() );
		setRequiredAccountStatus( src.getRequiredAccountStatus() );
		setOptionalDfltSysGrpName( src.getOptionalDfltSysGrpName() );
		setOptionalDfltClusGrpName( src.getOptionalDfltClusGrpName() );
		setOptionalDfltTentGrpName( src.getOptionalDfltTentGrpName() );
		setRequiredEMailAddress( src.getRequiredEMailAddress() );
		setRequiredRevision( src.getRequiredRevision() );
    }

	@Override
    public void set( ICFSecSecUserH src ) {
		setSecUser( src );
    }

	@Override
    public void setSecUser( ICFSecSecUserH src ) {
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setRequiredLoginId( src.getRequiredLoginId() );
		setRequiredAccountStatus( src.getRequiredAccountStatus() );
		setOptionalDfltSysGrpName( src.getOptionalDfltSysGrpName() );
		setOptionalDfltClusGrpName( src.getOptionalDfltClusGrpName() );
		setOptionalDfltTentGrpName( src.getOptionalDfltTentGrpName() );
		setRequiredEMailAddress( src.getRequiredEMailAddress() );
		setRequiredRevision( src.getRequiredRevision() );
    }

    public String getXmlAttrFragment() {
        String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredLoginId=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredLoginId() ) + "\""
			+ " RequiredAccountStatus=" + "\"" + getRequiredAccountStatus().toString() + "\""
			+ " OptionalDfltSysGrpName=" + ( ( getOptionalDfltSysGrpName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDfltSysGrpName() ) + "\"" )
			+ " OptionalDfltClusGrpName=" + ( ( getOptionalDfltClusGrpName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDfltClusGrpName() ) + "\"" )
			+ " OptionalDfltTentGrpName=" + ( ( getOptionalDfltTentGrpName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDfltTentGrpName() ) + "\"" )
			+ " RequiredEMailAddress=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEMailAddress() ) + "\"";
        return( ret );
    }

    public String toString() {
        String ret = "<CFSecBuffSecUserH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
