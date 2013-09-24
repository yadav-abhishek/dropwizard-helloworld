import sys
import subprocess
from bottle import route, run, get, post, static_file, request

globalScripts = []
# default API Key
globalApiKey = 'foobar'

def run_scripts(scripts=[]):
   for script in scripts:
      process = subprocess.Popen([script], shell=True)
      process.wait()
      
@get('/')
def index():
   return { 'status': 'ok', 'links': [{ 'ref': 'redeploy', 'href': '/redeploy/<apikey>', 'method': 'GET' }]}
   
@get('/redeploy/<apikey>')
def redeploy(apikey):
   if apikey != globalApiKey:
      return { 'msg': 'Invalid API Key' }
      
   run_scripts(globalScripts)
   return static_file('deployer.log', root='/tmp/')

@post('/redeploy/<apikey>')
def redeploy(apikey):
   if apikey != globalApiKey:
      return { 'msg': 'Invalid API Key' }

   run_scripts(globalScripts)
   return { 'msg': 'check the log file for the deployment status' }
   
def main():
   # let the server listen to all interfaces   
   run(host='0.0.0.0', port=9000)
   
if __name__ == "__main__":
   if len(sys.argv) > 2:
      globalApiKey = sys.argv[1]
      globalScripts = sys.argv[2:]
   
   print "API Key is " + globalApiKey    
   print "Scripts to be run: %s" % str(globalScripts)
   main()
