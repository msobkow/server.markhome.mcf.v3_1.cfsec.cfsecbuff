
// Description: Java 25 Default Factory implementation for SecUserPWHistory buffers

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
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

/*
 *	CFSecBuffSecUserPWHistoryFactory implementation of ICFSecSecUserPWHistoryFactory for SecUserPWHistory
 */
public class CFSecBuffSecUserPWHistoryDefaultFactory
	implements ICFSecSecUserPWHistoryFactory
{
	public CFSecBuffSecUserPWHistoryDefaultFactory() {
	}

    @Override
    public ICFSecSecUserPWHistoryPKey newPKey() {
        ICFSecSecUserPWHistoryPKey pkey =
            new CFSecBuffSecUserPWHistoryPKey();
        return( pkey );
    }

	public CFSecBuffSecUserPWHistoryPKey ensurePKey(ICFSecSecUserPWHistoryPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWHistoryPKey) {
			return( (CFSecBuffSecUserPWHistoryPKey)key );
		}
		else {
			CFSecBuffSecUserPWHistoryPKey mapped = new CFSecBuffSecUserPWHistoryPKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWHistoryByUserIdxKey newByUserIdxKey() {
		ICFSecSecUserPWHistoryByUserIdxKey key =
			new CFSecBuffSecUserPWHistoryByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecUserPWHistoryByUserIdxKey ensureByUserIdxKey(ICFSecSecUserPWHistoryByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWHistoryByUserIdxKey) {
			return( (CFSecBuffSecUserPWHistoryByUserIdxKey)key );
		}
		else {
			CFSecBuffSecUserPWHistoryByUserIdxKey mapped = new CFSecBuffSecUserPWHistoryByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWHistoryBySetStampIdxKey newBySetStampIdxKey() {
		ICFSecSecUserPWHistoryBySetStampIdxKey key =
			new CFSecBuffSecUserPWHistoryBySetStampIdxKey();
		return( key );
	}

	public CFSecBuffSecUserPWHistoryBySetStampIdxKey ensureBySetStampIdxKey(ICFSecSecUserPWHistoryBySetStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWHistoryBySetStampIdxKey) {
			return( (CFSecBuffSecUserPWHistoryBySetStampIdxKey)key );
		}
		else {
			CFSecBuffSecUserPWHistoryBySetStampIdxKey mapped = new CFSecBuffSecUserPWHistoryBySetStampIdxKey();
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWHistoryByReplacedStampIdxKey newByReplacedStampIdxKey() {
		ICFSecSecUserPWHistoryByReplacedStampIdxKey key =
			new CFSecBuffSecUserPWHistoryByReplacedStampIdxKey();
		return( key );
	}

	public CFSecBuffSecUserPWHistoryByReplacedStampIdxKey ensureByReplacedStampIdxKey(ICFSecSecUserPWHistoryByReplacedStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWHistoryByReplacedStampIdxKey) {
			return( (CFSecBuffSecUserPWHistoryByReplacedStampIdxKey)key );
		}
		else {
			CFSecBuffSecUserPWHistoryByReplacedStampIdxKey mapped = new CFSecBuffSecUserPWHistoryByReplacedStampIdxKey();
			mapped.setRequiredPWReplacedStamp( key.getRequiredPWReplacedStamp() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWHistory newRec() {
		ICFSecSecUserPWHistory rec =
			new CFSecBuffSecUserPWHistory();
		return( rec );
	}

	public CFSecBuffSecUserPWHistory ensureRec(ICFSecSecUserPWHistory rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecUserPWHistory) {
			return( (CFSecBuffSecUserPWHistory)rec );
		}
		else {
			CFSecBuffSecUserPWHistory mapped = new CFSecBuffSecUserPWHistory();
			mapped.set(rec);
			return( mapped );
		}
	}
}
