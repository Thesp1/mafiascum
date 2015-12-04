package net.mafiascum.web.sitechat.server.inboundpacket.operator;

import org.apache.log4j.Logger;

import net.mafiascum.web.sitechat.server.SiteChatServer;
import net.mafiascum.web.sitechat.server.SiteChatUser;
import net.mafiascum.web.sitechat.server.SiteChatServer.SiteChatWebSocket;

public abstract class SiteChatInboundSignedInPacketOperator extends SiteChatInboundPacketOperator {

  private static final Logger logger = Logger.getLogger(SiteChatInboundSignedInPacketOperator.class.getName());
  
  public abstract void process(SiteChatServer siteChatServer, SiteChatUser siteChatUser, SiteChatWebSocket siteChatWebSocket, String siteChatInboundPacketJson) throws Exception;
  
  public void process(SiteChatServer siteChatServer, SiteChatWebSocket siteChatWebSocket, String siteChatInboundPacketJson) throws Exception {
    
    SiteChatUser siteChatUser = siteChatWebSocket.getSiteChatUser();
    if(siteChatUser == null) {
      //Not logged in.
      
      logger.error("User trying to leave conversation without first logging in.");
      return;
    }
    
    process(siteChatServer, siteChatUser, siteChatWebSocket, siteChatInboundPacketJson);
  }
}